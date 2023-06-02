package ma.dentaltooth.dentaltooth.repository;

import ma.dentaltooth.dentaltooth.model.users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
}
