package com.remzona.order_service.dto;

import lombok.Data;

@Data
public class VinOrderDTO {
  private String vinNumber;
  private String partName;
  private String auto;
  private String modelAuto;
}