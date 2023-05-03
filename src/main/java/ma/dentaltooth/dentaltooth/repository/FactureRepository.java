package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
