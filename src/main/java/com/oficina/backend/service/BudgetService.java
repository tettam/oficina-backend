package com.oficina.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.Budget;
import com.oficina.backend.model.entities.enums.BudgetStatus;
import com.oficina.backend.repository.BudgetRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

@Service
public class BudgetService {
  
  @Autowired
  private BudgetRepository repository;

  public List<Budget> findAll(){
    return repository.findAll();
  }

  public Budget findById(Long id){
    Optional<Budget> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Budget insert(Budget obj){
    LocalDateTime timeBudget =  LocalDateTime.now();
    obj.setStatus(BudgetStatus.ESPERANDO_AUTORIZACAO);
    obj.setEntryDate(timeBudget);
    return repository.save(obj);
  }

  public Budget update(Budget obj){
    try {
      return repository.save(obj);
    } catch (Exception e) {
      throw new ResourceNotFoundException(obj.getId());
    }
  }

  public void delete(Long id){
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      throw new DatabaseException(e.getMessage());
    }
    
  }
}
