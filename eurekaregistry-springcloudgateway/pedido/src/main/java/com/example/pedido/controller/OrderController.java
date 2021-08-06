package com.example.pedido.controller;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pedido.dto.OrderDto;
import com.example.pedido.entity.Order;
import com.example.pedido.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public String get() {
        return "Ok";
    }

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> newOrder(@RequestBody OrderDto orderDto) {

        try {

            System.out.println(orderDto);

            final Order order = new Order();
            order.setDateOrder(new Date());
            order.setIdClient(orderDto.getIdClient());
            order.setIdMenu(orderDto.getIdMenu());
            order.setIdRestaurant(orderDto.getIdRestaurant());
            order.setPrice(orderDto.getPrice());

            final Order newOrder = orderService.saveOrder(order);
            final URI uri = gerUri(newOrder.getId());

            return ResponseEntity.created(uri).body(newOrder);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    private URI gerUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/order/find/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
