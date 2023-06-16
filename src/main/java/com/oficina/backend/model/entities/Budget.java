package com.oficina.backend.model.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oficina.backend.model.entities.enums.BudgetStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name = "tb_budget")
public class Budget {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO  )
  private Long id;

  private LocalDateTime entryDate;
  private Double milageVehicle;
  private String observation;
  private BudgetStatus status;

  @ManyToOne
  @JoinColumn(name = "client_id")
  @Getter(value = AccessLevel.NONE)
  private Client client;

  @ManyToOne
  @JoinColumn(name = "vehicle_id")
  private Vehicle vehicle;

  @OneToMany(mappedBy = "budget", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  @Setter(value = AccessLevel.NONE)
  private List<ProductItem> items;

  public void setItems(List<ProductItem> list) {
    for(ProductItem x : list){
      x.setBudget(this);
    }
    this.items = list;
  }
  @JsonIgnore
  public Client getClient() {
    return client;
  }

  
}
