package edu.sliit.controller;


import edu.sliit.dto.Client;
import edu.sliit.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ClientController {
    @Autowired
    final ClientService service;

    @GetMapping("/get-all")
    public List<Client> getClient(){
        return service.getAll();
    }

    @PostMapping("/add-client")
    public void addClient(@RequestBody Client client){
        log.info("updated-> {}",client);
        service.addClient(client);
    }

    @GetMapping("/search-by-id/{id}")
    public Client getClientById(@PathVariable Integer id){
        return service.searchClientById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteClientById(@PathVariable Integer id){
        service.deleteClientById(id);
    }
    @PutMapping("/update-client")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateClient(@RequestBody Client client){
        service.updateClientById(client);
    }
}
