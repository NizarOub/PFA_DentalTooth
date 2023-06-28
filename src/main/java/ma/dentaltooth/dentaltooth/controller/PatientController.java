package ma.dentaltooth.dentaltooth.controller;



import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
import ma.dentaltooth.dentaltooth.service.LoginService;
import ma.dentaltooth.dentaltooth.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    private final IServicePatient servicePatient;

    @GetMapping
    public String viewPatientsList(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        model.addAttribute("patients", servicePatient.lire());
        return "patientList";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        // create model attribute to bind form data
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "addPatient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        servicePatient.creer(patient);
        return "redirect:/patient";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Patient patient = servicePatient.getPatientById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("patient", patient);
        return "update_patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.servicePatient.supprimer(id);
        return "redirect:/patient";
    }
}
