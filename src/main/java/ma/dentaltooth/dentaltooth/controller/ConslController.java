package ma.dentaltooth.dentaltooth.controller;

import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.IServiceConsultation;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
import ma.dentaltooth.dentaltooth.service.Impl.ConslServiceImpl;
import ma.dentaltooth.dentaltooth.service.RdvService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Consultation")
public class ConslController {
    private final RdvService rdvService;
    private final IServiceConsultation Conslservice;
    private final StaffRepository staffRepository;
    @GetMapping("/showNewRdvForm/{id}")
    public String showNewRdvForm(@PathVariable(value = "id") long id,Model model){
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        if (staff.getRoles().size() > 1) {
            String role = staff.getRoles().get(1).getName();
            model.addAttribute("name", role);
        } else{
            String role = staff.getRoles().get(0).getName();
            model.addAttribute("name", role);
        }
        // list des patients pour le select
        RendezVous rendezVous = rdvService.getRdvById(id);
        Consultation consultation = new Consultation();
        consultation.setRendezVous(rendezVous);
        model.addAttribute("rendezVous", rendezVous);
        model.addAttribute("consultation", consultation);
        return "addConsl";
    }
    @PostMapping("/saveConsl/{id}")
    public String saveRdv(@PathVariable(value = "id") long id,@ModelAttribute("consultation")Consultation consultation){
        RendezVous rendezVous = rdvService.getRdvById(id);
        consultation.setRendezVous(rendezVous);
        consultation.setDate(rendezVous.getDate());
       Conslservice.creer(consultation);
        return "redirect:/rdv";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,Model model){
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        if (staff.getRoles().size() > 1) {
            String role = staff.getRoles().get(1).getName();
            model.addAttribute("name", role);
        } else{
            String role = staff.getRoles().get(0).getName();
            model.addAttribute("name", role);
        }
        Consultation consultation = Conslservice.getConsultationById(id);
        model.addAttribute("consultation", consultation);
        return "updateConsl";
    }
    @PostMapping("/update/{id}")
    public String updateRdv(@PathVariable(value = "id") long id, Consultation consultation){
        consultation.setId(id);
        Conslservice.updateConsl(consultation);
        return "redirect:/rdv/" +consultation.getRendezVous().getId();
    }

}
