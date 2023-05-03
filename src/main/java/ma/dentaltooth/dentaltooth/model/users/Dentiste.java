package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.Caisse;
import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.Collection;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Dentiste extends Utilisateur{


    // Un dentiste peut avoir plusieurs rendez-vous
    @OneToMany(mappedBy = "dentiste")
    private Collection<RendezVous> rendezVous;

    // Un dentiste peut réaliser plusieurs consultations
    @OneToMany(mappedBy = "dentiste")
    private Collection<Consultation> consultations;

    // Un dentiste peut accéder à la caisse pour enregistrer des paiements de ses patients
    @OneToOne
    private Caisse caisse;
}
