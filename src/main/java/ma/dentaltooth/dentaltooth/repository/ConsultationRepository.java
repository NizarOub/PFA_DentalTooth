package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
