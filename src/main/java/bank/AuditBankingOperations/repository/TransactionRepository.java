package bank.AuditBankingOperations.repository;

import bank.AuditBankingOperations.model.Transaction;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    @Tailable
    public Flux<Transaction> findWithTailableCursorByCustomerId(String customerId);
}
