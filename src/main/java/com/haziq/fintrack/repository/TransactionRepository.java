package com.haziq.fintrack.repository;

import com.haziq.fintrack.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

}
