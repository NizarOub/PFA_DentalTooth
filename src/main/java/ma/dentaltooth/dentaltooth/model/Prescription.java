package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Collection;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodToStrict;

    @ManyToOne
    private Ordonnance ordonnance;

    @OneToMany(mappedBy = "prescription")
    private Collection<Medicament> medicamentList;
}
