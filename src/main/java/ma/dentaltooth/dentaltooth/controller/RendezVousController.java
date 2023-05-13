package ma.dentaltooth.dentaltooth.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class RendezVousController {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @GetMapping("/appointments")
    public String getAllAppointments(Model model) {
        List<RendezVous> appointmentsList = rendezVousRepository.findAll();
        model.addAttribute("appointmentsList", appointmentsList);
        return "appointments";
    }

    /*@PostMapping
    public ResponseEntity<RendezVous> addAppointment(@RequestBody RendezVous appointment) {
        RendezVous newAppointment = rendezVousRepository.save(appointment);
        return ResponseEntity.ok(newAppointment);
    }*/
    @RequestMapping("/AddAppointments")
    public String AddAppointments(Model model){
        model.addAttribute("appointment",new RendezVous());
        return "AddAppointments";
    }

    @RequestMapping("/save1")
    public String save(Model model,RendezVous appointments, BindingResult bindingResult){

        if (bindingResult.hasErrors())
        rendezVousRepository.save(appointments);
        return "AddAppointments";


    }


/*
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getAppointmentById(@PathVariable Long id) {
        Optional<RendezVous> appointment = rendezVousRepository.findById(id);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateAppointment(@PathVariable Long id, @RequestBody RendezVous updatedAppointment) {
        Optional<RendezVous> appointment = rendezVousRepository.findById(id);
        if (appointment.isPresent()) {
            RendezVous existingAppointment = appointment.get();
            existingAppointment.setDate(updatedAppointment.getDate());
            existingAppointment.setDentiste(updatedAppointment.getDentiste());
            existingAppointment.setPatient(updatedAppointment.getPatient());
            existingAppointment.setSecretaire(updatedAppointment.getSecretaire());

            RendezVous savedAppointment = rendezVousRepository.save(existingAppointment);
            return ResponseEntity.ok(savedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        Optional<RendezVous> appointment = rendezVousRepository.findById(id);
        if (appointment.isPresent()) {
            rendezVousRepository.delete(appointment.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
