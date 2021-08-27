package com.example.cadastro.dto;


import org.modelmapper.ModelMapper;

import com.example.cadastro.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {

    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuOrderDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuOrderDto.class);
    }
}
