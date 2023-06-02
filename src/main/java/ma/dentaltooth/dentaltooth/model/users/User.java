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
    protected Long id;
    protected String email;
    protected String pass;
    protected String nom;
    protected String prenom;
    protected String cin;
    protected String tel;

@Table
public abstract class User {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String email;
    private String pass;
    private String nom;
    private String prenom;
    private String cin;
    private String tel;

    @Enumerated(EnumType.STRING)
    protected Sexe sexe;
    protected Date dateNaissance;
    protected LocalDateTime dateCreation;
    protected LocalDateTime dateModification;
    protected LocalDateTime dateDernierAuth;
    protected String photo;

}
}