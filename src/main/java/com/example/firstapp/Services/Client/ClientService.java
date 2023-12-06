package com.example.firstapp.Services.Client;

import com.example.firstapp.Entity.Client;

import java.util.List;

public interface ClientService {

    Client getClientByNom(String Nom);

    List<Client> getAllClient();

    Client creatClient(Client client);

    Client getClientByID(Long id);

    Client updateClient(Client product);

    void deleteClient(Long id);
}
