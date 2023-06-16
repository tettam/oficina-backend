package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.ProductItem;
import com.oficina.backend.repository.ProductItemRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductItemService {
  
  @Autowired
  private ProductItemRepository repository;

  public List<ProductItem> findAll(){
    return repository.findAll();
  }

  public ProductItem findById(Long id){
    Optional<ProductItem>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public ProductItem insert(ProductItem obj){
    return repository.saveAndFlush(obj);
  }

  public ProductItem update(ProductItem obj){
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
