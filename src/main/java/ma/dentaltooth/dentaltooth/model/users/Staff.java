package ma.dentaltooth.dentaltooth.model.users;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.Roles;


import java.util.ArrayList;

import java.util.Collection;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table
public class Staff extends User{
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Roles> roles = new ArrayList<>();


    @OneToMany(mappedBy = "staff")
    private List<Patient> patients;
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;
    public Staff(String name, String email, String password, List<Roles> roles) {
        this.nom = name;
        this.email = email;
        this.pass = password;
        this.roles = roles;
    }



}
