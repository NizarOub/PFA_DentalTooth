package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.RendezVous;

import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Staff extends User{
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
    private Collection<Patient> patients;
    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVousList;
}
