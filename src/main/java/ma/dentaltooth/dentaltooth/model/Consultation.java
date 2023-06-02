package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToOne
    private SituationFinanciere situationFinanciere;

    @ManyToOne
    private RendezVous rendezVous;

    @OneToMany(mappedBy = "consultation")
    private List<Ordonnance> ordonnanceList;

    @OneToMany(mappedBy = "consultation")
    private List<IM> imList ;
}
