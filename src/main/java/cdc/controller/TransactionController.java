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
    TransactionServiceImpl transactionServiceImpl;

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable int id){
        return transactionServiceImpl.getTransaction(id);
    }


    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionServiceImpl.getAllTransactions();
    }

    @GetMapping("/transactions/{page}")
    public List<Transaction> getSomeTransaction(@PathVariable int page){
        return transactionServiceImpl.getSomeTransactions(page).toList();
    }


    @PutMapping("/transaction")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionServiceImpl.updateTransaction(transaction);
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
