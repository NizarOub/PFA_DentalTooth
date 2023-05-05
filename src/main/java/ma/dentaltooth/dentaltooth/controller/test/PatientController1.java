package ma.dentaltooth.dentaltooth.controller.test;


import ma.dentaltooth.dentaltooth.service.test.PatientService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController1 {

    @Autowired
    private PatientService2 patientService;


    /*
    @GetMapping("/patients")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "4") int s,
                        @RequestParam(name = "keyword",defaultValue = "") String  kw){
        Page<Patient> patientPage = patientService.findPatientByPrenom(kw,PageRequest.of(p,s));
        model.addAttribute("patientList", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", p);
        model.addAttribute("keyword", kw);
        return "patients";
    }

    @GetMapping("delete")
    public String delete(long id, String keyword, int page){
        patientService.deletePatient(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

     */
}
