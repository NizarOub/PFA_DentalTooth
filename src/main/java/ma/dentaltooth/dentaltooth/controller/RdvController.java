package ma.dentaltooth.dentaltooth.controller;


import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
import ma.dentaltooth.dentaltooth.service.RdvService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rdv")
public class RdvController {

    private final RdvService rdvService;
    private final IServicePatient servicePatient;
    private final StaffRepository staffRepository;


    @GetMapping
    public String RdvList(Model model){
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        if (staff.getRoles().size() > 1) {
            String role = staff.getRoles().get(1).getName();
            model.addAttribute("name", role);
        } else{
            String role = staff.getRoles().get(0).getName();
            model.addAttribute("name", role);
        }
        model.addAttribute("rdv", rdvService.lire());
        return "rdvList";
    }

    @GetMapping("/showNewRdvForm")
    public String showNewRdvForm(Model model){
        // list des patients pour le select
        model.addAttribute("patients", servicePatient.lire());
        RendezVous rendezVous = new RendezVous();
        model.addAttribute("rdv", rendezVous);
        return "addRdv";
    }

    @PostMapping("/saveRdv")
    public String saveRdv(@ModelAttribute("rdv")RendezVous rdv){
        rdvService.creer(rdv);
        return "redirect:/rdv";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,Model model){
        model.addAttribute("patients", servicePatient.lire());
        RendezVous rendezVous = rdvService.getRdvById(id);
        model.addAttribute("rdv", rendezVous);
        return "updateRdv";
    }

    @PostMapping("/update/{id}")
    public String updateRdv(@PathVariable(value = "id") long id, RendezVous rendezVous){
        rendezVous.setId(id);
        rdvService.updateRdv(rendezVous);
        return "redirect:/rdv";

    }
    @GetMapping("/deleteRdv/{id}")
    public String deleteRdv(@PathVariable(value = "id") long id){
        rdvService.supprimer(id);
        return "redirect:/rdv";
    }

}
