package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.example.cadastro.dto.MenuDto;

import lombok.Data;

@Data
@Entity(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public static Menu create(MenuDto menuDto) {
        return new ModelMapper().map(menuDto, Menu.class);
    }

}
