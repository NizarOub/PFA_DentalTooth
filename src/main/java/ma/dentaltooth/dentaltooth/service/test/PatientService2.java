package ma.dentaltooth.dentaltooth.service.test;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService2 implements IPatientService2 {
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public List<Patient> getAllPatient() {
        return this.patientRepository.findAll();
    }

    // paginated
    @Override
    public Page<Patient> getAllPatientPage(int p, int s) {
        return this.patientRepository.findAll(PageRequest.of(p,s));
    }

    @Override
    public Page<Patient> findPatientByPrenom(String keyword, Pageable pageable) {
        return this.patientRepository.findByPrenomContains(keyword,pageable);
    }

    @Override
    public Page<Patient> chercherPatient(String keyword, Pageable pageable) {
        return this.patientRepository.chercher(keyword,pageable);
    }

    @Override
    public void deletePatient(long id) {
        this.patientRepository.deleteById(id);
    }


}
