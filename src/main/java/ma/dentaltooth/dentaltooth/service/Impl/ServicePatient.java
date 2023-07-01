package ma.dentaltooth.dentaltooth.service.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.IServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Patient creer(Patient patient) {
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        patient.setStaff(staff);
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

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
