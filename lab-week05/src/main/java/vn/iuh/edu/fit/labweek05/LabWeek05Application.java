package vn.iuh.edu.fit.labweek05;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.frontend.models.Address;
import vn.iuh.edu.fit.labweek05.frontend.models.Candidate;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class LabWeek05Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek05Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;

//    @Bean
//    CommandLineRunner initData(){
//        return args -> {
//            Random rnd = new Random();
//            for(int i = 1; i < 1000; i++) {
//                String number = rnd.nextInt(70000,80000)+"";
//                String zipcode = (CountryCode.VN)+"";
//                Address address = new Address((long) i, "Quang Trung", "HCM", (short)1, number, zipcode);
//                addressRepository.save(address);
//
//                Candidate can = new Candidate(
//                        (long) i,
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        "email" + i + "@gmail.com",
//                        "Name #" + i,
//                        rnd.nextLong(1111111111L, 9999999999L)+"",
//                        address );
//                candidateRepository.save(can);
//                System.out.println("Added: " + can);
//            }
//        };
//    }
}
