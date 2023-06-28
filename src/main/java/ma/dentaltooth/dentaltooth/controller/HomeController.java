package ma.dentaltooth.dentaltooth.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String viewHomePage(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "accueil";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
}