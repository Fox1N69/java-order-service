package com.remzona.order_service.service;

import com.remzona.order_service.entity.Order;
import com.remzona.order_service.entity.VinOrder;
import com.remzona.order_service.repository.OrderRepository;
import com.remzona.order_service.repository.VinOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private VinOrderRepository vinOrderRepository;

  public Long createOrderWithVinOrder(Order order) {
    VinOrder vinOrder = order.getVinOrder();
    VinOrder savedVinOrder = vinOrderRepository.save(vinOrder);

    if (savedVinOrder != null) {
      order.setVinOrder(savedVinOrder);
      Order savedOrder = orderRepository.save(order);
      return savedOrder.getId();
    } else {
      return null; // Failed to save VinOrder
    }
  }

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public void deleteVinOrderById(Long id) {
    vinOrderRepository.deleteById(id);
  }
}
