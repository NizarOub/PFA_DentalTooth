package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.model.users.Sexe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByPrenomContains(String keyword, Pageable pageable);
    @Query("select p from Patient p where p.prenom like :x")
    Page<Patient> chercher(@Param("x") String keyword, Pageable pageable);

    @Modifying
    @Query(value = "update Patient p set p.cin =: cin," + "p.nom =: nom," + "p.prenom =: prenom," +
                    "p.adresse =: adresse," + "p.dateNaissance =: dateDeNaissance," +
                    "p.tel =: tel," + "p.mutuelle =: mutuelle," + "p.sexe =: sexe where p.id =: id")
    void updatePatient(String cin, String nom, String prenom, String adresse, Date dateDeNaissance, String tel, String mutuelle, String sexe,long id);

}
