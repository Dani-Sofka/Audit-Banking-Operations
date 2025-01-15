package bank.AuditBankingOperations.dto;

import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.enums.WithdrawalType;
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
    private LocalDateTime localDateTime;
}
