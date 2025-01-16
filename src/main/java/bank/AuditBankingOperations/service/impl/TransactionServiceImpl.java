package bank.AuditBankingOperations.service.impl;


import bank.AuditBankingOperations.dto.request.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.response.TransactionResponseDTO;
import bank.AuditBankingOperations.mapper.TransactionMapper;
import bank.AuditBankingOperations.model.Transaction;
import bank.AuditBankingOperations.repository.TransactionRepository;
import bank.AuditBankingOperations.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Mono<TransactionResponseDTO> saveTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = TransactionMapper.toEntity(transactionRequestDTO);
        return transactionRepository.save(transaction)
                .map(TransactionMapper::toResponseDTO);
    }

    @Override
    public Flux<TransactionResponseDTO> getTransactionById(long id) {
        return transactionRepository.findByCustomerId(id)
                .map(TransactionMapper::toResponseDTO);
    }
}
