package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.dentaltooth.dentaltooth.model.users.Staff;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Staff> users = new ArrayList<>();

    public Roles(String name) {
        this.name = name;
    }
}
