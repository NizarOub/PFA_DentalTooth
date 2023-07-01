package ma.dentaltooth.dentaltooth.service;

import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.RendezVousRepository;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceStaff implements ISerivceStaff {

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
}
