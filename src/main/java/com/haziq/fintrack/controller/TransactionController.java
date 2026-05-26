package com.haziq.fintrack.controller;

import com.haziq.fintrack.dto.TransactionRequestDto;
import com.haziq.fintrack.entity.Transaction;
import com.haziq.fintrack.service.CategoryService;
import com.haziq.fintrack.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;

    public TransactionController(
            TransactionService transactionService,
            CategoryService categoryService
    ) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/transactions") // when user opens /transactions page
    public String getTransactions(Model model) { // Model = container to send data to HTML page
        // get all transactions from DB
        model.addAttribute(
                "transactions",
                transactionService.getAllTransactions()
        );

        // send categories to HTML for dropdown
        model.addAttribute(
                "categories",
                categoryService.getAllCategory()
        );

        model.addAttribute(
                "totalIncome",
                transactionService.getTotalIncome()
        );

        model.addAttribute(
                "totalExpense",
                transactionService.getTotalExpense()
        );

        model.addAttribute(
                "balance",
                transactionService.getBalance()
        );

        return "transactions";
    }

    @PostMapping("/transactions/save")
    public RedirectView saveTransaction(@ModelAttribute TransactionRequestDto dto) {

        transactionService.save(dto);

        return new RedirectView("/transactions");
    }

    @GetMapping("/transactions/delete/{id}")
    public RedirectView deleteTransaction(
            @PathVariable Long id // PathVariable takes value from URL
    ) {
        transactionService.deleteById(id); // call service delete method
        return new RedirectView("/transactions"); // reload transaction page
    }
}
