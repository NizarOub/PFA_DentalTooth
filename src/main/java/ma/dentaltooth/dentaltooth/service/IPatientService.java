package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPatientService {

    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    Patient getPatientById(long id);
    void deletePatientById(long id);
    Page<Patient> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
