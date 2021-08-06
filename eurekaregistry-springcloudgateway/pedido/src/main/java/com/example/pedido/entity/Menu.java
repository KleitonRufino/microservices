package com.example.pedido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.example.pedido.dto.MenuOrderDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static Menu create(MenuOrderDto menuOrderDto) {
        return new ModelMapper().map(menuOrderDto, Menu.class);
    }

}
