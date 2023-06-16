package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.Client;
import com.oficina.backend.repository.ClientRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
  
  @Autowired
  private ClientRepository repository;

  public List<Client> findAll(){
    return repository.findAll();
  }

  public Client findById(Long id){
    Optional<Client>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Client insert(Client obj){
    String clientName = obj.getName().toLowerCase();
    clientName = clientName.substring(0, 1).toUpperCase() + clientName.substring(1);
    obj.setName(clientName);
    return repository.saveAndFlush(obj);
  }

  public Client update(Client obj){
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
