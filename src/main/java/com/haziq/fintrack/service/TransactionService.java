package com.haziq.fintrack.service;

import com.haziq.fintrack.entity.Transaction;
import com.haziq.fintrack.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    public double getTotalIncome() {
        // start from 0
        double total = 0;
        // loop all transactions
        for (Transaction transaction : transactionRepository.findAll()) {
            // check if transaction type is INCOME
            if ("INCOME".equals(transaction.getType())) {
                // add amount into total
                total += transaction.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpense() {
        double total = 0;
        for (Transaction transaction : transactionRepository.findAll()) {
            if ("EXPENSE".equals(transaction.getType())) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

    public double getBalance() {
        // income minus expense
        return getTotalIncome() - getTotalExpense();
    }
}