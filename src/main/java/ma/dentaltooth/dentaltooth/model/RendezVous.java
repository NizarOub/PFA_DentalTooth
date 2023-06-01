package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Staff;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
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

    @OneToMany(mappedBy = "rendezVous",fetch = FetchType.LAZY)
    private Collection<Consultation> consultationList;
}
