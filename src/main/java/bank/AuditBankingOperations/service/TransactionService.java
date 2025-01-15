package bank.AuditBankingOperations.service;

import bank.AuditBankingOperations.dto.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.TransactionResponseDTO;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<TransactionResponseDTO> saveTransaction(TransactionRequestDTO transactionRequestDTO);
    Mono<TransactionResponseDTO> getTransactionById(String id);
    Mono<TransactionResponseDTO> getAllTransaction();
}
