package com.example.wafaapp.repositories;

import com.example.wafaapp.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card, Long> {
}
