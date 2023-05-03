package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.*;
import ma.dentaltooth.dentaltooth.model.users.Dentiste;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Secretaire;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")

    private Long id;
    private LocalDateTime date;
    private String status;

    @ManyToOne
    private Dentiste dentiste;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "consultation")
    private Collection<Acte> actes;

    @OneToOne(mappedBy = "consultation")
    private RendezVous rendezVous;
}
