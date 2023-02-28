package cdc.service;



import cdc.entitie.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransaction(Transaction transaction);
    void deleteTransactionById(int id);
    Transaction getTransaction(int id);
    List<Transaction> getAllTransactions();
}
