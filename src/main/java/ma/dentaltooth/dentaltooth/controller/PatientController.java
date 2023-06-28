package ma.dentaltooth.dentaltooth.controller;



import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.service.LoginService;
import ma.dentaltooth.dentaltooth.service.ServicePatient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller


@AllArgsConstructor
public class PatientController {
    private ServicePatient patientService;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPatient", patientService.lire());
        return "index";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        // create model attribute to bind form data
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "AddPatient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        // save employee to database
        patientService.creer(patient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Patient patient = patientService.getPatientById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("patient", patient);
        return "update_patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.patientService.supprimer(id);
        return "redirect:/";
    }
}
