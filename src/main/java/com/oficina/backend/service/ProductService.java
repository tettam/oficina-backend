package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.Product;
import com.oficina.backend.repository.ProductRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository repository;

  public List<Product> findAll(){
    return repository.findAll();
  }

  public Product findById(Long id){
    Optional<Product>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Product insert(Product obj){
    return repository.saveAndFlush(obj);
  }

  public Product update(Product obj){
    try {
      return repository.saveAndFlush(obj);
    } catch (EntityNotFoundException e) {
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
