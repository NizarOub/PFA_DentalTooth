package ma.dentaltooth.dentaltooth.service.test;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService2 {

    List<Patient> getAllPatient();
    Page<Patient> getAllPatientPage(int p, int s);

    Page<Patient> findPatientByPrenom(String keyword, Pageable pageable);
    Page<Patient> chercherPatient(String keyword, Pageable pageable);

    void deletePatient(long id);
}