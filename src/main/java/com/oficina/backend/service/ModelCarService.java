package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.ModelCar;
import com.oficina.backend.repository.ModelCarRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModelCarService {
  
  @Autowired
  private ModelCarRepository repository;

  public List<ModelCar> findAll(){
    return repository.findAll();
  }

  public ModelCar findById(Long id){
    Optional<ModelCar>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public ModelCar insert(ModelCar obj){
    return repository.saveAndFlush(obj);
  }

  public ModelCar update(ModelCar obj){
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
