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

import com.oficina.backend.model.entities.Vehicle;
import com.oficina.backend.service.VehicleService;


@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
  
  @Autowired
  private VehicleService service;

  @GetMapping
  public ResponseEntity<List<Vehicle>> findAll(){
    List<Vehicle> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Vehicle> findById(@PathVariable Long id){
    Vehicle obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Vehicle> add(@RequestBody Vehicle obj){
    Vehicle object = service.insert(obj);
    return ResponseEntity.created(null).body(object);
  }

  @PutMapping
  public ResponseEntity<Vehicle> update(@RequestBody Vehicle obj){
    service.update(obj);
    return ResponseEntity.ok().body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
