package bank.AuditBankingOperations.mapper;

import bank.AuditBankingOperations.dto.request.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.response.TransactionResponseDTO;
import bank.AuditBankingOperations.enums.TransactionType;
import bank.AuditBankingOperations.model.Transaction;

import java.time.LocalDateTime;

public class TransactionMapper {

    /*
        Converter de Transaction a TransactionResponseDTO (para devolve una respuesta con la transacción)
     */
    public static TransactionResponseDTO toResponseDTO(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.WITHDRAWAL) {
            return new TransactionResponseDTO(
                    transaction.getTransactionType(),
                    transaction.getInitialBalance(),
                    transaction.getFinalBalance(),
                    transaction.getAmount(),
                    transaction.getCreatedAt(),
                    transaction.getWithdrawalType()
            );
        }
        return new TransactionResponseDTO(
                transaction.getTransactionType(),
                transaction.getInitialBalance(),
                transaction.getFinalBalance(),
                transaction.getAmount(),
                transaction.getCreatedAt(),
                null
        );
    }

    /*
        Convertir de TransactionRequestDTO a Transaction (para cuando guardamos una nueva transacción)
     */
    public static Transaction toEntity(TransactionRequestDTO requestDTO) {
        return Transaction.builder()
                .customerId(requestDTO.getCustomerId())
                .transactionType(requestDTO.getTransactionType())
                .initialBalance(requestDTO.getInitialBalance())
                .amount(requestDTO.getAmount())
                .finalBalance(requestDTO.getInitialBalance() + requestDTO.getAmount())
                .createdAt(LocalDateTime.now())
                .withdrawalType(requestDTO.getWithdrawalType())
                .build();
    }
}
