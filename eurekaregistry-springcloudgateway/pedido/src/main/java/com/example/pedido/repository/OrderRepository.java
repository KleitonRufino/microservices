package com.example.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pedido.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
