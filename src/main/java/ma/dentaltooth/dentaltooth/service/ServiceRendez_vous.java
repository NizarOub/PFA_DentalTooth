package ma.dentaltooth.dentaltooth.service;

import lombok.AllArgsConstructor;
import ma.dentaltooth.dentaltooth.model.RendezVous;
import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import ma.dentaltooth.dentaltooth.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceRendez_vous implements IServiceRendezVous  {
    @Autowired
    private RendezVousRepository rendezVousRepository;



    public RendezVous creer(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }


    public List<RendezVous> lire() {
        return rendezVousRepository.findAll();
    }


    public String supprimer(Long id) {
        rendezVousRepository.deleteById(id);
        return "rendez-vous supprimer";
    }

    public RendezVous getRendezVousById(long id) {
        Optional< RendezVous > optional = rendezVousRepository.findById(id);
        RendezVous rendezVous = null;
        if (optional.isPresent()) {
           rendezVous  = optional.get();
        } else {
            throw new RuntimeException(" rendez-vous not found for id :: " + id);
        }
        return rendezVous;
    }




    public void updateRendezVous(RendezVous rendezVous) {
        rendezVousRepository.save(rendezVous);
    }
}
