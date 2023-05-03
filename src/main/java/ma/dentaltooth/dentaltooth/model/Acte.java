package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;

import java.util.Collection;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Table
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acte_id")
    private Long id;
    private String libelle;
    private String description;
    private double prix;
    private String categorie;

    @ManyToOne
    private Consultation consultation;

    @ManyToOne
    private Secretaire secretaire;
}
