package ma.dentaltooth.dentaltooth.controller;


import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

 /*   @GetMapping("/index")
    public String patients(Model model,
                          @RequestParam(name = "page",defaultValue ="0") int page,
                           @RequestParam(name = "size",defaultValue = "5")int size

    ){
        Page<Patient> patientPage =patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("patientList",patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("pagecourante",page);

        return "patients";
    }*/

    @GetMapping("/index")
    public String patients(Model model) {
        List<Patient> patientList = patientRepository.findAll();
        model.addAttribute("patientList", patientList);
        return "patients";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/layout";
    }



}
