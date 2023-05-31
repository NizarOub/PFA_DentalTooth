package ma.dentaltooth.dentaltooth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @ManyToOne
    private IM im;

    @OneToMany(mappedBy = "acte")
    private List<ActeCategory> acteMedicalList;

}
