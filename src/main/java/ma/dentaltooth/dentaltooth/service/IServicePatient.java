package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Patient;

import java.util.Date;
import java.util.List;

public interface IServicePatient {
    Patient creer(Patient patient);
    List<Patient> lire();

    String supprimer(Long id);
    Patient getPatientById(long id);

    void updatePatient(long id, String cin, String nom, String prenom, String adresse, Date dateDeNaissance, String tel, String mutuelle, String sexe);
}
