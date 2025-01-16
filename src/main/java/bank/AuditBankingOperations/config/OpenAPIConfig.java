package bank.AuditBankingOperations.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration

@OpenAPIDefinition(
        info = @Info(
                title="Funds",
                version = "1.0.0",
                description = "This project technical test",
                contact = @Contact(
                        name = "Audit",
                        url = "https://audit.com.co",
                        email = "audit@audit.com.co"
                ),
                license = @License(
                        name = "propiedad",
                        url = "https://audit.com.co/"
                )
        )
)

public class OpenAPIConfig {
}