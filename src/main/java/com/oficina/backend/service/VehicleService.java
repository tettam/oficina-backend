package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.Vehicle;
import com.oficina.backend.repository.VehicleRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VehicleService {
  
  @Autowired
  private VehicleRepository repository;

  public List<Vehicle> findAll(){
    return repository.findAll();
  }

  public Vehicle findById(Long id){
    Optional<Vehicle>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Vehicle insert(Vehicle obj){
    return repository.saveAndFlush(obj);
  }
  public Vehicle update(Vehicle obj){
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
