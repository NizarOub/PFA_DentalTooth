package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.List;

public interface RdvService {
    RendezVous creer(RendezVous rendezVous);
    List<RendezVous> lire();
    String supprimer(long id);

    RendezVous getRdvById(long id);
    void updateRdv(RendezVous rendezVous);
}
