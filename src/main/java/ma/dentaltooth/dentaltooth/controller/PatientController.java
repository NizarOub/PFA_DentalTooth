package ma.dentaltooth.dentaltooth.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import ma.dentaltooth.dentaltooth.repository.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/patients")
    public String patients(Model model) {
        List<Patient> patientList = patientRepository.findAll();
        model.addAttribute("patientList", patientList);
        return "patients";
    }

    @GetMapping("/")
    public String home(){
        return "Accueil";
    }
    @GetMapping("/Accueil")
    public String Accueil(){
        return "Accueil";
    }

    @GetMapping("/AddPatient")
    public String addPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "AddPatient";
    }
    @RequestMapping("/delete")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }



    @PostMapping("/save")
    public String enregistrerPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients";
    }


}
