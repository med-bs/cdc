package cdc.service;



import cdc.entitie.Transaction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    List<Transaction> saveBatchTransaction(List<Transaction> transactions);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransaction(Transaction transaction);
    void deleteTransactionById(int id);
    Transaction getTransaction(int id);
    List<Transaction> getAllTransactions();
    Page<Transaction> getSomeTransactions(int numPage);

}
