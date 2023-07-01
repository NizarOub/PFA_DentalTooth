package ma.dentaltooth.dentaltooth.controller;

import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
import ma.dentaltooth.dentaltooth.service.ISerivceStaff;
import ma.dentaltooth.dentaltooth.service.IServiceRendezVous;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/RendezVous")
public class RendezVousController {
    private final IServiceRendezVous serviceRendezVous;
    private final ISerivceStaff serviceStaff;
    private final IServicePatient servicePatient;


    @GetMapping
    public String viewRendezVousList(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        model.addAttribute("rendezvous", serviceRendezVous.lire());
        return "patientList";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("rendezVous", new RendezVous());
        List<Staff> staffs = serviceStaff.getAllStaff();
        model.addAttribute("staffs", staffs);

        return "AddAppointments";
    }

    @PostMapping("/savePatient")
    public String saveRendezVous(@ModelAttribute("rendezvous") RendezVous rendezVous) {
        serviceRendezVous.creer(rendezVous);
        return "redirect:/RendezVous";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        RendezVous rendezVous = serviceRendezVous.getRendezVousById(id);
        model.addAttribute("rendezvous", rendezVous);
        return "update2";
    }

    @PostMapping("/update/{id}")
    public String updateRendezVous(@PathVariable(value = "id") long id, RendezVous rendezVous){
        rendezVous.setId(id);
        serviceRendezVous.updateRendezVous(rendezVous);
        return "redirect:/RendezVous";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.serviceRendezVous.supprimer(id);
        return "redirect:/RendezVous";
    }
}
