package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.pfa.dentaltooth.model.HistoriqueMedical;
import ma.pfa.dentaltooth.model.RendezVous;
import ma.pfa.dentaltooth.model.SituationFinanciere;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient extends User{
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVousList;
    @OneToMany(mappedBy = "patient")
    private List<HistoriqueMedical> historiqueMedicalList;
    @OneToMany(mappedBy = "patient")
    private List<SituationFinanciere> situationFinanciereList;

    @ManyToOne
    private Staff staff;
}
