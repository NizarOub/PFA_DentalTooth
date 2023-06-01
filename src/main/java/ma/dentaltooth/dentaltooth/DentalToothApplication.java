package ma.dentaltooth.dentaltooth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DentalToothApplication {


    public static void main(String[] args) {
        SpringApplication.run(DentalToothApplication.class, args);
    }

}
