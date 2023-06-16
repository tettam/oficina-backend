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

import com.oficina.backend.model.entities.ModelCar;
import com.oficina.backend.service.ModelCarService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/carmodels")
@CrossOrigin("http://localhost:5173")
public class ModelCarController {
  
  @Autowired
  private ModelCarService service;

  @GetMapping
  public ResponseEntity<List<ModelCar>> findAll(){
    List<ModelCar> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ModelCar> findById(@PathVariable Long id){
    ModelCar obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<ModelCar> add(@RequestBody @Valid ModelCar obj){
    ModelCar object = service.insert(obj);
    return ResponseEntity.created(null).body(object);
  }

  @PutMapping
  public ResponseEntity<ModelCar> update(@RequestBody ModelCar obj){
    ModelCar object = service.update(obj);
    return ResponseEntity.ok().body(object);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
