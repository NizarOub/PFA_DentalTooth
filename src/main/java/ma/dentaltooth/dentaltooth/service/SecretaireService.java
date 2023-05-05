package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.model.users.Secretaire;
import ma.dentaltooth.dentaltooth.repository.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaireService implements ISecretaireService{

    @Autowired
    private SecretaireRepository secretaireRepository;
    @Override
    public List<Secretaire> getAllSecretaires() {
        return this.secretaireRepository.findAll();
    }
}
