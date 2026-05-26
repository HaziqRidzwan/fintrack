package com.haziq.fintrack.controller;

import com.haziq.fintrack.dto.TransactionRequestDto;
import com.haziq.fintrack.entity.Category;
import com.haziq.fintrack.entity.Transaction;
import com.haziq.fintrack.service.TransactionService;
import com.haziq.fintrack.dto.TransactionResponseDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController // RestController means: return JSON data directly, NOT HTML page
@RequestMapping("/api/transactions") // base URL for all APIs in this controller
public class TransactionApiController {

    private final TransactionService transactionService; // dependency injection, controller needs service

    public TransactionApiController(TransactionService transactionService) {
        this.transactionService = transactionService; // save injected service into variable
    }

    @GetMapping // GET /api/transactions, retrieve all transactions
    public List<TransactionResponseDto> getAllTransactions() {
        return transactionService.getAllTransactionDtos(); // call service to get all data
    }

    @PostMapping
    public String saveTransaction(

            @Valid
            @RequestBody
            TransactionRequestDto dto
    ) {

        // send dto into service
        transactionService.save(dto);

        return "Transaction saved successfully";
    }

    @DeleteMapping("/{id}") // DELETE /api/transactions/1
    public String deleteTransaction(
            @PathVariable Long id // PathVariable means: get value from URL
    ) {
        transactionService.deleteById(id); // delete transaction
        return "Transaction deleted successfully"; // return simple message
    }
}