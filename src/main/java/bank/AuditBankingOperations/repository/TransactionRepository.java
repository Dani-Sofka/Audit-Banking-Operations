package bank.AuditBankingOperations.repository;

import bank.AuditBankingOperations.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, Long> {
}
