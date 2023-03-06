package cdc.service;


import cdc.entitie.Transaction;
import cdc.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    private final int defaultPageSize=10;
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> saveBatchTransaction(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, int id) {
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public void deleteTransactionById(int id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransaction(int id) {
        return transactionRepository.findById(2).get();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Page<Transaction> getSomeTransactions(int numPage, int pageSize) {
        Pageable pageable = PageRequest.of(numPage, pageSize);
        return transactionRepository.findAll(pageable);
    }
}
