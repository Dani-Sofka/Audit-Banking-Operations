package bank.AuditBankingOperations.dto.request;

import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.enums.WithdrawalType;
import bank.AuditBankingOperations.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    private Long customerId;
    private TransactionType transactionType;
    private double initialBalance;
    private double amount;
    private WithdrawalType withdrawalType;
}
