package ma.dentaltooth.dentaltooth.controller;


import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;
import ma.dentaltooth.dentaltooth.service.IPatientService;
import ma.dentaltooth.dentaltooth.service.ISecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @Autowired
    private ISecretaireService secretaireService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "nom", "asc", model);
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        // create model attribute to bind form data
        Patient patient = new Patient();
        List<Secretaire> secretaireList = secretaireService.getAllSecretaires();
        model.addAttribute("patient", patient);
        model.addAttribute("secretaireList", secretaireList);
        return "new_patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        // save employee to database
        patientService.savePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get employee from the service
        Patient patient = patientService.getPatientById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("patient", patient);
        return "update_patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.patientService.deletePatientById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Patient> page = patientService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Patient> patientList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("patientList", patientList);
        return "index";
    }
}
