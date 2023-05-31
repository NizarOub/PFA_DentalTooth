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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String email;
    private String pass;
    private String nom;
    private String prenom;
    private String cin;
    private String tel;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private Date dateNaissance;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private LocalDateTime dateDernierAuth;
    private String photo;

}
