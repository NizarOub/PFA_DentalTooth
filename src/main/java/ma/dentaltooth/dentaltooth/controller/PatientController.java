package ma.dentaltooth.dentaltooth.controller;



import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
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
    private final StaffRepository staffRepository;

    @GetMapping
    public String viewPatientsList(Model model) {
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        if (staff.getRoles().size() > 1) {
            String role = staff.getRoles().get(1).getName();
            model.addAttribute("name", role);
        } else{
            String role = staff.getRoles().get(0).getName();
            model.addAttribute("name", role);
        }
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

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Patient patient = servicePatient.getPatientById(id);
        model.addAttribute("patient", patient);
        return "update2";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable(value = "id") long id, Patient patient){
        patient.setId(id);
        servicePatient.updatePatient(patient);
        return "redirect:/patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.servicePatient.supprimer(id);
        return "redirect:/patient";
    }
}
