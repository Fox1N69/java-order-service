package com.remzona.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;
  private String email;
  private String phoneNumber;
  private String deliveryCity;
  private String deliveryAddress;
  private double deliveryCost;
  private String paymentMethod;
  private String comment;
  private String trackingNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "vin_order_id", referencedColumnName = "id")
  private VinOrder vinOrder;
}