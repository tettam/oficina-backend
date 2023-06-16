package com.oficina.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_model_car")
@Data
public class ModelCar {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "Preencha com o modelo do veículo")
  @Size(min = 2)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "modelCar", cascade = CascadeType.ALL)
  private List<Vehicle> listVehicle = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "brandCar_id")
  private BrandCar brandCar;
}
