package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.example.cadastro.dto.RestaurantDto;

import lombok.Data;

@Data
@Entity(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String user;
    private String password;

    public static Restaurant create(RestaurantDto restaurantDto) {
        return new ModelMapper().map(restaurantDto, Restaurant.class);
    }


}
