package bank.AuditBankingOperations.model;


import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.enums.WithdrawalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String transactionId;
    private String customerId;
    private TransactionType transactionType;
    private double initialBalance;
    private double finalBalance;
    private double amount;
    private LocalDateTime createdAt;
    private WithdrawalType withdrawalType;
}
