package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPatientService {

    List<Patient> getAllPatient();
    Page<Patient> getAllPatientPage(int p, int s);

    Page<Patient> findPatientByPrenom(String keyword, Pageable pageable);
    Page<Patient> chercherPatient(String keyword, Pageable pageable);

    void deletePatient(long id);
}
