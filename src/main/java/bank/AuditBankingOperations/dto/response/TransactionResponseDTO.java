package bank.AuditBankingOperations.dto.response;

import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.enums.WithdrawalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private TransactionType transactionType;
    private double initialBalance;
    private double finalBalance;
    private double amount;
    private LocalDateTime localDateTime;
    private WithdrawalType withdrawalType;
}
