package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int montant_total;
    private LocalDateTime date;
    private String status;

    @OneToOne
    private Caisse caisse;
}
