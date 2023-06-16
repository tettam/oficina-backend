package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
  
}
