package com.haziq.fintrack.service;

import com.haziq.fintrack.dto.TransactionRequestDto;
import com.haziq.fintrack.entity.Category;
import com.haziq.fintrack.entity.Transaction;
import com.haziq.fintrack.repository.CategoryRepository;
import com.haziq.fintrack.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import com.haziq.fintrack.dto.TransactionResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    public void save(TransactionRequestDto dto) {
        // get category from DB using dto
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        // create entity
        Transaction transaction = new Transaction();

        transaction.setTitle(dto.getTitle());
        transaction.setAmount(dto.getAmount());
        transaction.setType(dto.getType());
        transaction.setCategory(category);

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

    public List<TransactionResponseDto> getAllTransactionDtos() {

        // get all entities from database
        List<Transaction> transactions =  transactionRepository.findAll();

        // create empty DTO list
        List<TransactionResponseDto> dtoList = new ArrayList<>();

        // loop all transactions
        for (Transaction transaction : transactions) {

            // create DTO object
            TransactionResponseDto dto = new TransactionResponseDto();

            // copy id from entity to dto
            dto.setId(transaction.getId());

            // copy title
            dto.setTitle(transaction.getTitle());

            // copy amount
            dto.setAmount(transaction.getAmount());

            // copy type
            dto.setType(transaction.getType());

            // copy category name only
            dto.setCategoryName(transaction.getCategory().getName());

            // add dto into list
            dtoList.add(dto);
        }

        // return dto list
        return dtoList;
    }
}