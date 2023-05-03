package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int montant_total;
    private String date;
    private String status;

    @OneToOne
    private Caisse caisse;
}
