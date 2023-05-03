package ma.dentaltooth.dentaltooth.model.users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.DossierMedicale;
import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.Collection;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "patient_name")
    private String nom;
    @Column(name = "patient_prenom")
    private String prenom;
    private String adresse;
    private String tel;
    private String mutuelle;


    // Un Patient peut avoir plusieurs RendezVous
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;

    // Un Patient peut avoir plusieurs Consultations
    @OneToMany(mappedBy = "patient")
    private Collection<Consultation> consultations;

    // Un Patient peut avoir un seul DossierMedical
    @OneToOne(mappedBy = "patient")
    private DossierMedicale dossierMedicale;

    // Un Patient peut être créé par une Secrétaire
    @ManyToOne
    private Secretaire secretaire;



}
