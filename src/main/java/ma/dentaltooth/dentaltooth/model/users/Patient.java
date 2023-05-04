package ma.dentaltooth.dentaltooth.model.users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.DossierMedicale;
import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table
@PrimaryKeyJoinColumn(name = "user_id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mutuelle;


    // Un Patient peut avoir plusieurs RendezVous
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

    // Un Patient peut avoir plusieurs Consultations
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Consultation> consultations;

    // Un Patient peut avoir un seul DossierMedical
    @OneToOne(mappedBy = "patient")
    private DossierMedicale dossierMedicale;

    // Un Patient peut être créé par une Secrétaire
    @ManyToOne
    private Secretaire secretaire;



}
