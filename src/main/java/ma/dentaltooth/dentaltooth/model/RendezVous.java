package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Dentiste;
import ma.dentaltooth.dentaltooth.model.users.Patient;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne
    private Dentiste dentiste;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Patient secretaire;
    @OneToOne
    private Consultation consultation;
}
