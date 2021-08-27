package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.example.cadastro.dto.ClientDto;

import lombok.Data;

@Data
@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String user;
    private String password;

    public static Client create(ClientDto clientDto) {
        return new ModelMapper().map(clientDto, Client.class);
    }

}
