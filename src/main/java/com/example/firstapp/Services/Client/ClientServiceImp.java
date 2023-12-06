package com.example.firstapp.Services.Client;

import com.example.firstapp.Entity.Client;
import com.example.firstapp.Repository.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository ;


    public Client getClientByNom(String Nom){

        return clientRepository.getClientByNom(Nom);
    }

    public List<Client> getAllClient(){

        return clientRepository.findAll();
    }

    @Override
    public Client creatClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client getClientByID(Long id) {

        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {

        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
