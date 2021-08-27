package com.example.pedido.message;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.pedido.dto.ClientOrderDto;
import com.example.pedido.entity.Client;
import com.example.pedido.repository.ClientRepository;

@Component
public class ClientReceiveMessage {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientReceiveMessage(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RabbitListener(queues = {"${cadastro.client.rabbitmq.queue}"})
    public void receive(@Payload ClientOrderDto clientOrderDto) {
        System.out.println(clientOrderDto);
        clientRepository.save(Client.create(clientOrderDto));
    }

}
