package cdc.controller;

import cdc.entitie.Transaction;
import cdc.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;
    private final int pageSize=10;

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable int id){
        return transactionServiceImpl.getTransaction(id);
    }


    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionServiceImpl.getAllTransactions();
    }

    @GetMapping("/transactions/{numPage}")
    public List<Transaction> getSomeTransaction(@PathVariable int numPage){
        return transactionServiceImpl.getSomeTransactions(numPage,pageSize).toList();
    }


    @PutMapping("/transaction/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable int id){
        return transactionServiceImpl.updateTransaction(transaction,id);
    }

    @PostMapping ("/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionServiceImpl.saveTransaction(transaction);
    }

    @PostMapping("/transactions")
    public List<Transaction> addBatchTransactions(@RequestBody ArrayList<Transaction> transactions){
        return transactionServiceImpl.saveBatchTransaction(transactions);
    }

    /*
    @DeleteMapping("/delete")
    public void deleteTransaction(@RequestBody Transaction transaction){
        transactionServiceImpl.deleteTransaction(transaction);
    }
    */



}
