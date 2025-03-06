package bank.AuditBankingOperations.services.integration;


import bank.AuditBankingOperations.dto.request.TransactionRequestDTO;
import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.enums.WithdrawalType;
import bank.AuditBankingOperations.model.Transaction;
import bank.AuditBankingOperations.repository.TransactionRepository;
import bank.AuditBankingOperations.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureWebTestClient
public class TransactionControllerTest {

    public static final long CUSTOMER_ID = 123L;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @BeforeEach
    public void setup(){
        transactionRepository.deleteAll().block();
    }

    @Test
    public void testStreamTransactionByCustomerId_Deposit(){
        Transaction transaction = Transaction.builder()
                .customerId(CUSTOMER_ID)
                .transactionType(TransactionType.DEPOSIT)
                .initialBalance(1500)
                .amount(500)
                .finalBalance(2000)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction).block();

        webTestClient.get()
                .uri("/api/audit/transaction?id=" + CUSTOMER_ID)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TransactionRequestDTO.class)
                .consumeWith(response -> {
                    TransactionRequestDTO requestDTO = response.getResponseBody().get(0);

                    assertNotNull(requestDTO);
                    assertEquals(CUSTOMER_ID, requestDTO.getCustomerId());
                    assertEquals("DEPOSIT", requestDTO.getTransactionType());
                });
    }

    @Test
    public void testStreamTransactionByCustomerId_Withdrawal(){
        Transaction transaction = Transaction.builder()
                .customerId(CUSTOMER_ID)
                .transactionType(TransactionType.WITHDRAWAL)
                .initialBalance(1000)
                .amount(200)
                .finalBalance(800)
                .createdAt(LocalDateTime.now())
                .withdrawalType(WithdrawalType.ATM)
                .build();

        transactionRepository.save(transaction).block();

        webTestClient.get()
                .uri("/api/audit/transaction?id=" + CUSTOMER_ID)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].customerId").isEqualTo(CUSTOMER_ID)
                .jsonPath("$[0].transactionType").isEqualTo("WITHDRAWAL")
                .jsonPath("$[0].withdrawalType").isEqualTo("ATM");
    }
}
