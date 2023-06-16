package com.oficina.backend.model.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tb_vehicle")
@Data
public class Vehicle {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "É necessário a placa de identificação do veículo!")
  private String licensePlate;
  private Double milage;
  private String color;
  private Integer carModelData;

  @ManyToOne
  @JoinColumn(name = "client_id")
  @JsonBackReference
  private Client client;

  @ManyToOne
  @JoinColumn(name = "modelCar_id")
  private ModelCar modelCar;

  @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Budget> budgets;
}
