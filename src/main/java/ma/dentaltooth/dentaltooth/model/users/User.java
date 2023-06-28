package ma.dentaltooth.dentaltooth.model.users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    protected String email;
    protected String pass;
    protected String nom;
    protected String prenom;
    protected String cin;
    protected String tel;

    protected String adresse;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private Date dateNaissance;


}
