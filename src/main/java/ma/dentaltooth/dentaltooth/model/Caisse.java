package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;
import ma.dentaltooth.dentaltooth.model.users.Dentiste;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String montant;

    private String description;
    private LocalDateTime date;

    @OneToOne
    private Dentiste dentiste;
    @OneToOne
    private Secretaire secretaire;
    @OneToOne(mappedBy = "caisse")
    private Facture facture;

}
