package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService{
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
