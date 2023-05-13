package ma.dentaltooth.dentaltooth.controller;

import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patient")
@AllArgsConstructor
public class PatientController {
    private PatientService patientService;
    @PostMapping("/create")
    Patient create(@RequestBody Patient patient){
       return patientService.creer(patient);
    }
    @GetMapping("/read")
    List<Patient> read(){
       return patientService.lire();
    }
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable Long id){

        return patientService.supprimer(id);
    }
}
