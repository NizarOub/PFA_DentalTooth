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

    @OneToOne(mappedBy = "caisse")
    private Dentiste dentiste;
    @OneToOne(mappedBy = "caisse")
    private Secretaire secretaire;
    @OneToOne(mappedBy = "caisse")
    private Facture facture;

}
