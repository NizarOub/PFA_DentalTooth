package ma.dentaltooth.dentaltooth;

import ma.dentaltooth.dentaltooth.model.users.Patient;
import ma.dentaltooth.dentaltooth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DentalToothApplication {


    public static void main(String[] args) {
        SpringApplication.run(DentalToothApplication.class, args);
    }

}
