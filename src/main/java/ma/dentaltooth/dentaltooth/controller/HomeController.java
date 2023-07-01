package ma.dentaltooth.dentaltooth.controller;

import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.model.users.User;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StaffRepository staffRepository;


    @GetMapping
    public String viewHomePage(Model model) {
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        if (staff.getRoles().size() > 1) {
            String role = staff.getRoles().get(1).getName();
            model.addAttribute("name", role);
        } else{
            String role = staff.getRoles().get(0).getName();
            model.addAttribute("name", role);
        }
        return "accueil";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
}