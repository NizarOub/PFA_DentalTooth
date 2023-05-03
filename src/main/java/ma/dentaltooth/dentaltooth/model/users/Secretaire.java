package ma.dentaltooth.dentaltooth.model.users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.*;

import java.util.Collection;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Table
public class Secretaire extends Utilisateur {

    // Une secrétaire peut gérer plusieurs patients
    @OneToMany(mappedBy = "secretaire")
    private Collection<Patient> patients;

    // Une secrétaire peut planifier plusieurs rendez-vous
    @OneToMany(mappedBy = "secretaire")
    private Collection<RendezVous> rendezVous;

    // Une secrétaire peut gérer plusieurs dossiers médicaux
    @OneToMany(mappedBy = "secretaire")
    private Collection<DossierMedicale> dossierMedicaux;

    // Une secrétaire peut enregistrer plusieurs actes réalisés
    @OneToMany(mappedBy = "secretaire")
    private Collection<Acte> actes;

    // Une secrétaire peut générer plusieurs statistiques sur l'activité du cabinet dentaire
    @OneToMany(mappedBy = "secretaire")
    private Collection<Statistique> statistiques;

    // Une secrétaire peut accéder à la caisse pour enregistrer des paiements de ses patients
    @OneToOne
    private Caisse caisse;
}
