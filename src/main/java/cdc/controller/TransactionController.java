package cdc.controller;

import cdc.entitie.Transaction;
import cdc.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trasaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable int id){
        return transactionServiceImpl.getTransaction(id);
    }


    @GetMapping("/findAll")
    public List<Transaction> getAllTransaction(){
        return transactionServiceImpl.getAllTransactions();
    }

    @PutMapping("/update")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionServiceImpl.updateTransaction(transaction);
    }

    @PostMapping ("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionServiceImpl.saveTransaction(transaction);
    }


    /*
    @DeleteMapping("/delete")
    public void deleteTransaction(@RequestBody Transaction transaction){
        transactionServiceImpl.deleteTransaction(transaction);
    }
    */

    //pagination

}
