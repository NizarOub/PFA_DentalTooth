package ma.dentaltooth.dentaltooth.service;

import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient {
    @Autowired
    private PatientRepository patientRepository;



    @Override
    public Patient creer(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> lire() {
        return patientRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        patientRepository.deleteById(id);
        return "Patient supprimer";
    }
    @Override
    public Patient getPatientById(long id) {
        Optional< Patient > optional = patientRepository.findById(id);
        Patient patient = null;
        if (optional.isPresent()) {
            patient = optional.get();
        } else {
            throw new RuntimeException(" patient not found for id :: " + id);
        }
        return patient;
    }
}
