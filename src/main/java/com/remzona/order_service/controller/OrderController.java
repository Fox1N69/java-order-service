package com.remzona.order_service.controller;

import com.remzona.order_service.dto.VinOrderDTO;
import com.remzona.order_service.entity.Order;
import com.remzona.order_service.entity.VinOrder;
import com.remzona.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/api/order-vin")
  public ResponseEntity<VinOrder> postOrderVin(@RequestBody VinOrderDTO vinOrderDTO) {
    VinOrder vinOrder = mapDtoToEntity(vinOrderDTO);

    Order order = new Order();
    order.setVinOrder(vinOrder);

    Long orderId = orderService.createOrderWithVinOrder(order);
    return new ResponseEntity<>(vinOrder, HttpStatus.OK);
  }

  private VinOrder mapDtoToEntity(VinOrderDTO vinOrderDTO) {
    VinOrder vinOrder = new VinOrder();
    vinOrder.setVinNumber(vinOrderDTO.getVinNumber());
    vinOrder.setPartName(vinOrderDTO.getPartName());
    vinOrder.setAuto(vinOrderDTO.getAuto());
    vinOrder.setModelAuto(vinOrderDTO.getModelAuto());
    return vinOrder;
  }
}
