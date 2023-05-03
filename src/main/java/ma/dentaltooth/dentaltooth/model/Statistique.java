package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class Statistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int valeur;

    @ManyToOne
    private Secretaire secretaire;
}
