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

import com.oficina.backend.model.entities.BrandCar;
import com.oficina.backend.service.BrandCarService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/brands")
public class BrandCarController {
  
  @Autowired
  private BrandCarService service;

  @GetMapping
  public ResponseEntity<List<BrandCar>> findAll(){
    List<BrandCar> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<BrandCar> findById(@PathVariable Long id){
    BrandCar obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<BrandCar> add(@RequestBody @Valid BrandCar obj){
    BrandCar object = service.insert(obj);
    return ResponseEntity.created(null).body(object);
  }

  @PutMapping
  public ResponseEntity<BrandCar> update(@RequestBody BrandCar obj){
    service.update(obj);
    return ResponseEntity.ok().body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
