package cvut.fel;

import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Account accountcustom = new Account(55);
        accountcustom.setAmount(666);
        Customer customer1 = new Customer("Paulo");
        customer1.setPhonenumber(06);
        customer1.setAccount(accountcustom);
        Customer customer2 = new Customer("Dybala");
        customer2.setPhonenumber(95);
        Customer customer3 = new Customer("Roma");
        customer3.setPhonenumber(46);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        System.out.println("\nfindAll()");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindByName('Paulo')");
        customerRepository.findByName("Paulo").forEach(System.out::println);

        Account account1 = new Account(500);
        account1.setAmount(1500);
        Account account2 = new Account(55);
        account2.setAmount(400);
        Account account3 = new Account(1000);
        account3.setAmount(35);
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);
        accountRepository.save(accountcustom);
        System.out.println("\nfindAll()");
        accountRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindById(55L)");
        accountRepository.findById(2L).ifPresent(System.out::println);
    }

}