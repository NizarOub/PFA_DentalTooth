package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.HistoriqueMedical;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.SituationFinanciere;

import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Patient extends User{

    private String mutuelle;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Collection<RendezVous> rendezVousList;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<HistoriqueMedical> historiqueMedicalList;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<SituationFinanciere> situationFinanciereList;

    @ManyToOne
    private Staff staff;
}
