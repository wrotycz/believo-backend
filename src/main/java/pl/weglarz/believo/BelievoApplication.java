package pl.weglarz.believo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class BelievoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BelievoApplication.class, args);
    }
}
