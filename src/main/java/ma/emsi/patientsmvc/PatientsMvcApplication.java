package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            for (int i=1; i<=50; i++){
                Patient patient = new Patient();
                patient.setNom("Patient"+i);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random()<0.5?false:true);
                patient.setScore(i*100);
                patientRepository.save(patient);
            }
        };
    }
}
