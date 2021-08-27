package com.example.cadastro.controller;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cadastro.dto.RestaurantDto;
import com.example.cadastro.entity.Restaurant;
import com.example.cadastro.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {

        try {

            final Restaurant restaurant = restaurantService.saveRestaurant(Restaurant.create(restaurantDto));

            URI uri = gerUri(restaurant.getId());

            return ResponseEntity.created(uri).body(restaurant);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    private URI gerUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/restaurant/find/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto) {

        try {

            Restaurant restaurant = Restaurant.create(restaurantDto);
            restaurant.setId(id);

            restaurant = restaurantService.updateRestaurant(restaurant);

            return Objects.nonNull(restaurant) ? ResponseEntity.ok().body(restaurant) :
                    ResponseEntity.notFound().build();


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {

        return restaurantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


}
