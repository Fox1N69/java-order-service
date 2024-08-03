package com.remzona.order_service.dto;

import lombok.Data;

@Data
public class OrderDTO {
  private String status;
  private String email;
  private String phoneNumber;
  private String deliveryCity;
  private String deliveryAddress;
  private double deliveryCost;
  private String paymentMethod;
  private String comment;
  private String trackingNumber;
  private VinOrderDTO vinOrder;
}
