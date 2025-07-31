package com.example.wafaapp.repositories;

import com.example.wafaapp.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionDao extends JpaRepository<Transaction, Long> {

}
