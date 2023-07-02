package ma.dentaltooth.dentaltooth.service.Impl;

import ma.dentaltooth.dentaltooth.Auth.SecurityUtil;
import ma.dentaltooth.dentaltooth.model.Consultation;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.ConsultationRepository;
import ma.dentaltooth.dentaltooth.repository.RendezVousRepository;
import ma.dentaltooth.dentaltooth.repository.StaffRepository;
import ma.dentaltooth.dentaltooth.service.IServiceConsultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConslServiceImpl  implements IServiceConsultation
{
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public Consultation creer(Consultation consultation) {
        String username = SecurityUtil.getSessionUser();


        return consultationRepository.save(consultation);

    }

    @Override
    public List<Consultation> lire() {
        return consultationRepository.findAll();
    }

    @Override
    public String supprimer(long id) {
        consultationRepository.deleteById(id);
        return "Consl supprimer";
    }

    @Override
    public Consultation getConsultationById(long id) {
        Optional<Consultation> optional = consultationRepository.findById(id);
        Consultation consultation = null;
        if (optional.isPresent()){
            consultation = optional.get();
        } else {
            throw new RuntimeException("Consultation not found");
        }
        return consultation;
    }

    @Override
    public void updateConsl(Consultation consultation) {
        consultationRepository.save(consultation);
    }
}
