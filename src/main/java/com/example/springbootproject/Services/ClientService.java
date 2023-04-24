package com.example.springbootproject.Services;

import com.example.springbootproject.Entities.Client;
import com.example.springbootproject.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ClientService {
    private ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).get();
    }
    public Client createClient(Client client) {

        return clientRepository.save(client);
    }
    public Client updateClient(Client client) {

        return clientRepository.save(client);
    }
    public void deleteClientById(int id) {

        clientRepository.deleteById(id);
        return;
    }


}
