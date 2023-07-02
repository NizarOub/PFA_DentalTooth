package ma.dentaltooth.dentaltooth.service.Impl;

import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.RendezVousRepository;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RdvServiceImpl implements RdvService {

    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public RendezVous creer(RendezVous rendezVous) {
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        rendezVous.setStaff(staff);
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> lire() {
        return rendezVousRepository.findAll();
    }

    @Override
    public String supprimer(long id) {
        rendezVousRepository.deleteById(id);
        return "Rdv supprimer";
    }

    @Override
    public RendezVous getRdvById(long id) {
        Optional<RendezVous> optional = rendezVousRepository.findById(id);
        RendezVous rendezVous = null;
        if (optional.isPresent()){
            rendezVous = optional.get();
        } else {
            throw new RuntimeException("Rdv not found");
        }
        return rendezVous;
    }

    @Override
    public void updateRdv(RendezVous rendezVous) {
        String username = SecurityUtil.getSessionUser();
        Staff staff = staffRepository.findStaffByEmail(username);
        rendezVous.setStaff(staff);
        rendezVousRepository.save(rendezVous);
    }
}
