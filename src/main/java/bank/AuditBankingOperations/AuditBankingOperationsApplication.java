package bank.AuditBankingOperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class AuditBankingOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditBankingOperationsApplication.class, args);
	}

}
