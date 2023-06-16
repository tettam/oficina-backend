package com.oficina.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.backend.model.entities.Budget;
import com.oficina.backend.service.BudgetService;



@RestController
@RequestMapping(value = "budgets")
@CrossOrigin("http://localhost:5173")
public class BudgetController {
  
  @Autowired
  private BudgetService service;

  @GetMapping
  public ResponseEntity<List<Budget>> findAll(){
    List<Budget> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Budget> findById(@PathVariable Long id){
    Budget obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Budget> insert(@RequestBody Budget obj){
    Budget object = service.insert(obj);
    return ResponseEntity.status(201).body(object);
  }

  @PutMapping
  public ResponseEntity<Budget> update(@RequestBody Budget obj){
    Budget object = service.update(obj);
    return ResponseEntity.ok().body(object);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }


  
}
