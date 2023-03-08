package cdc.controller;

import cdc.entitie.Transaction;
import cdc.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransactionUiContraller {

    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping("/list/{pageNum}")
    public String viewListPage(@PathVariable int pageNum, Model model){
        int pageSize = 10;

        Page<Transaction> page = transactionService.getSomeTransactions(pageNum - 1, pageSize);
        List<Transaction> listTransaction = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listTransaction", listTransaction);

        return "index";
    }

    @GetMapping("/newtransaction")
    public String viewNewTransactionForm(Model model){
        Transaction transaction = new Transaction();
        model.addAttribute("transaction",transaction);
        return "addTransaction";
    }

    @PostMapping("/newtransaction")
    public String addNewTransaction(@ModelAttribute("transaction") Transaction transaction){
        transactionService.saveTransaction(transaction);
        return "redirect:/list/1";
    }

    @GetMapping("/updatetransaction/{id}")
    public String viewUpdateTransactionForm(@PathVariable int id, Model model){
        Transaction transaction = transactionService.getTransaction(id);

        model.addAttribute("transaction", transaction);

        return "updateTransaction";
    }

}
