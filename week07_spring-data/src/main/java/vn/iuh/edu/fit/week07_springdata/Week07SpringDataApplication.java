package vn.iuh.edu.fit.week07_springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import vn.iuh.edu.fit.week07_springdata.models.Account;
import vn.iuh.edu.fit.week07_springdata.repositories.AccountRepository;

import java.util.Random;

@SpringBootApplication
public class Week07SpringDataApplication implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(Week07SpringDataApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Random rnd = new Random();
//        for(int i = 0; i < 100; i++){
//            Account account = new Account();
//            account.setOwnerName("Owner "+i);
//            account.setBalance(rnd.nextDouble()*1000);
//            accountRepository.save(account);
//        }
//        PageRequest request = PageRequest.of(5, 6);
    }
}
