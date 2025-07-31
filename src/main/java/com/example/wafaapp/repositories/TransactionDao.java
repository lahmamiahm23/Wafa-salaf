package com.example.wafaapp.repositories;

import com.example.wafaapp.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDao extends CrudRepository<Transaction, Long> {
}
