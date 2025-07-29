package edu.sliit.service;

import edu.sliit.dto.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();

    void addClient(Client client);

    void deleteClientById(Integer id);

    Client searchClientById(Integer id);

    void updateClientById(Client client);
}
