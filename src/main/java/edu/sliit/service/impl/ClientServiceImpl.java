package edu.sliit.service.impl;

import edu.sliit.dto.Client;
import edu.sliit.entity.ClientEntity;
import edu.sliit.repository.ClientRepository;
import edu.sliit.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Client> getAll() {
        List<Client> ClientArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            ClientArrayList.add(mapper.map(entity, Client.class));
        });
        return ClientArrayList;
    }

    @Override
    public void addClient(Client client) {
        System.out.println(client);
        repository.save(mapper.map(client, ClientEntity.class));
    }

    @Override
    public void deleteClientById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Client searchClientById(Integer id) {
        return mapper.map(repository.findById(id),Client.class);


    }

    @Override
    public void updateClientById(Client client) {
        repository.save(mapper.map(client, ClientEntity.class));
    }
}
