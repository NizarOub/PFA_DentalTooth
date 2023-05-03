package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.Acte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ActeRepository extends JpaRepository<Acte,Long> {
}
