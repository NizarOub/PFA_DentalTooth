package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends JpaRepository<Staff, Long> {
    Staff findByEmail(String email);
}