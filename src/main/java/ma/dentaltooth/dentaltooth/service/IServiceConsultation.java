package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.List;

public interface IServiceConsultation {
    Consultation creer(Consultation consultation);
    List<Consultation> lire();
    String supprimer(long id);

    Consultation getConsultationById(long id);
    void updateConsl(Consultation consultation);
}
