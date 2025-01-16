package bank.AuditBankingOperations.repository;

import bank.AuditBankingOperations.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, Long> {
    @Tailable
    public Flux<Transaction> findByCustomerId(long customerId);
}
