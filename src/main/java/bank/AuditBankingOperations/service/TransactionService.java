package bank.AuditBankingOperations.service;

import bank.AuditBankingOperations.dto.request.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.response.TransactionResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<TransactionResponseDTO> saveTransaction(TransactionRequestDTO transactionRequestDTO);
    Flux<TransactionResponseDTO> streamTransaction(String customerId);
}
