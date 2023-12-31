package com.oficina.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.backend.model.entities.Client;
import com.oficina.backend.service.ClientService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/clients")
public class ClientController {
  
  @Autowired
  private ClientService service;

  @GetMapping
  public ResponseEntity<List<Client>> findAll(){
    List<Client> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Client> findById(@PathVariable Long id){
    Client obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Client> add(@RequestBody @Valid Client obj){
    Client object = service.insert(obj);
    return ResponseEntity.status(201).body(object);
  }

  @PutMapping
  public ResponseEntity<Client> update(@RequestBody Client obj){
    Client object = service.update(obj);
    return ResponseEntity.ok().body(object);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
