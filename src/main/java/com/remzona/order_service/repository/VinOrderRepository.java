package com.remzona.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remzona.order_service.entity.VinOrder;

@Repository
public interface VinOrderRepository extends JpaRepository<VinOrder, Long> {

}
