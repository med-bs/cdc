package cdc.controller;

import cdc.entitie.Transaction;
import cdc.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
