package com.example.wafaapp.repositories;

import com.example.wafaapp.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDao extends JpaRepository<Branch ,Long > {
}
