package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table
public class DossierMedicale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String antecedents;
    private String allergies;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Secretaire secretaire;

}
