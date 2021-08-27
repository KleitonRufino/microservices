package com.example.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro.dto.ClientOrderDto;
import com.example.cadastro.entity.Client;
import com.example.cadastro.message.ClientSendMessage;
import com.example.cadastro.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ClientService {

    private final ClientSendMessage clientMessage;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientSendMessage clientMessage) {
        this.clientRepository = clientRepository;
        this.clientMessage = clientMessage;
    }

    public Client saveClient(Client client) throws JsonProcessingException {
        final Client newClient = clientRepository.save(client);
        clientMessage.sendMessage(ClientOrderDto.create(newClient));
        return newClient;
    }

    public Client updateClient(Client client) throws JsonProcessingException {

        final Optional<Client> optional = clientRepository.findById(client.getId());

        if (optional.isPresent()) {
            return clientRepository.save(client);
        } else {
            return null;
        }

    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

}
