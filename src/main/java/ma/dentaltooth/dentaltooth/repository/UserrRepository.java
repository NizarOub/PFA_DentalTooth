package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends JpaRepository<Userr, Long> {
    Userr findByEmail(String email);
}