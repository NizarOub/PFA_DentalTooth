package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;


import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class SituationFinanciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAPayer;
    private double reste;
    private double paye;


    @OneToOne
    private Consultation consultation;

    @OneToMany(mappedBy = "situationFinanciere")
    private Collection<Facture> factures;

    @ManyToOne
    private Patient patient;
}
