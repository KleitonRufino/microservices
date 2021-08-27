package com.example.pedido.controller;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pedido.dto.OrderDto;
import com.example.pedido.entity.Order;
import com.example.pedido.jwt.JwtTokenUtil;
import com.example.pedido.proxy.ClientProxy;
import com.example.pedido.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
	private final JwtTokenUtil jwtTokenUtil;
    private final ClientProxy clientProxy;
    
    @GetMapping("/teste/{id}")
    public String get(@PathVariable("id") Long id) {
    	try {
    		var client = this.clientProxy.findById(id, jwtTokenUtil.getToken());
    		System.out.println(client);
    		return client.toString();
    	}catch (Exception e) {
    		return e.getMessage();
    	}
    }

    @Autowired
    public OrderController(OrderService orderService, JwtTokenUtil jwtTokenUtil, ClientProxy clientProxy) {
        this.orderService = orderService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.clientProxy = clientProxy;
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
