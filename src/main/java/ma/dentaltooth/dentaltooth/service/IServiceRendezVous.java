package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Patient;

import java.util.List;

public interface IServiceRendezVous {
    public RendezVous creer(RendezVous rendezVous);
    List<RendezVous> lire();

    String supprimer(Long id);
    RendezVous getRendezVousById(long id);

    void updateRendezVous(RendezVous rendezVous);
}
