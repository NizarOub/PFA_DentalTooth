package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.pfa.dentaltooth.model.users.Patient;
import ma.pfa.dentaltooth.model.users.Staff;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String motif;
    private String etat;
    private boolean estUrgent;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Staff staff;

    @OneToMany(mappedBy = "rendezVous")
    private List<Consultation> consultationList;
}
