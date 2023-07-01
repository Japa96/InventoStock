package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.Address;
import com.InventoStock.InventoStock.models.AddressDTO;
import com.InventoStock.InventoStock.models.Client;
import com.InventoStock.InventoStock.models.ClientDTO;
import com.InventoStock.InventoStock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Map<String, Object>> registerClient(ClientDTO clientDTO){

            try{
                Client client = new Client();
                client.setName(clientDTO.getName());
                client.setLastName(clientDTO.getLastName());
                client.setCpf(clientDTO.getCpf());
                client.setEmail(clientDTO.getEmail());
                client.setPhone(clientDTO.getPhone());

                Address address = new Address();
                address.setStreet(clientDTO.getAddress().getStreet());
                address.setNeighborhood(clientDTO.getAddress().getNeighborhood());
                address.setCity(clientDTO.getAddress().getCity());
                address.setState(clientDTO.getAddress().getState());
                address.setComplement(clientDTO.getAddress().getComplement());
                address.setZipCode(clientDTO.getAddress().getZipCode());
                address.setNumber(clientDTO.getAddress().getNumber());

                client.setAddress(address);

                clientRepository.save(client);

                Map<String, Object> response = new HashMap<>();
                response.put("id", client.getId());
                response.put("message", "Client registered successfully");

                return ResponseEntity.status(HttpStatus.CREATED).body(response);

            }catch (Exception e){

                Map<String, Object> response = new HashMap<>();
                response.put("message", "Fail to register client");
                response.put("error", e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

    }
}
