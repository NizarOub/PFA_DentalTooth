package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.pfa.dentaltooth.model.users.Patient;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistoriqueMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;
}
