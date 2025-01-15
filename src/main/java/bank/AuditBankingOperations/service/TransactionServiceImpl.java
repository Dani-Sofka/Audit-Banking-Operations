package bank.AuditBankingOperations.service;


import bank.AuditBankingOperations.dto.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.TransactionResponseDTO;
import bank.AuditBankingOperations.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Mono<TransactionResponseDTO> saveTransaction(TransactionRequestDTO request) {
        return transactionRepository.save(TransactionRequestDTO.toEntity(request))
                .map(TransactionResponseDTO::fromEntity);
    }

    @Override
    public Mono<TransactionResponseDTO> getTransactionById(String id) {
        return null;
    }

    @Override
    public Mono<TransactionResponseDTO> getAllTransaction() {
        return null;
    }
}
