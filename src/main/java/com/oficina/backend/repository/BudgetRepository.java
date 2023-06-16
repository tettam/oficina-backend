package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
  
}
