package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.Address;
import com.InventoStock.InventoStock.models.Client;
import com.InventoStock.InventoStock.models.ClientDTO;
import com.InventoStock.InventoStock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client registerClient(ClientDTO clientDTO){

        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setCpf(clientDTO.getCpf());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());

        Address address = new Address();
        address.setStreet(address.getStreet());
        address.setNeighborhood(address.getNeighborhood());
        address.setCity(address.getCity());
        address.setState(address.getState());
        address.setComplement(address.getComplement());
        address.setZipCode(address.getZipCode());
        address.setNumber(address.getNumber());

        client.setAddress(address);

        return clientRepository.save(client);
    }
}
