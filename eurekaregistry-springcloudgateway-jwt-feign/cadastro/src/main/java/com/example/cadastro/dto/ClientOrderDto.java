package com.example.cadastro.dto;

import org.modelmapper.ModelMapper;

import com.example.cadastro.entity.Client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientOrderDto {

    private String name;
    private Long idClient;

    public static ClientOrderDto create(Client client) {
        return new ModelMapper().map(client, ClientOrderDto.class);
    }

}
