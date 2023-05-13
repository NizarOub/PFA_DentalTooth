package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Patient;

import java.util.List;

public interface IServicePatient {
    Patient creer( Patient patient);
    List<Patient> lire();

    String supprimer(Long id);
}
