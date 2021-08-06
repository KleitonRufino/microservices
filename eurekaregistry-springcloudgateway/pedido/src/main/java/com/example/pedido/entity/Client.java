package com.example.pedido.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.example.pedido.dto.ClientOrderDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long idClient;

    private String name;

    public static Client create(ClientOrderDto clientOrderDto) {
        return new ModelMapper().map(clientOrderDto, Client.class);
    }

}
