package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.pfa.dentaltooth.model.RendezVous;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff extends User{
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "staff")
    private List<Patient> patients;
    @OneToMany(mappedBy = "staff")
    private List<RendezVous> rendezVousList;
}
