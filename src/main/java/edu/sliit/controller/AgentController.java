package edu.sliit.controller;

import edu.sliit.dto.Agent;
import edu.sliit.service.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/agent")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class AgentController {
    @Autowired
    final AgentService service;

    @GetMapping("/get-all")
    public List<Agent> getAgent(){
        return service.getAll();
    }

    @PostMapping("/add-agent")
    public void addAgent(@RequestBody Agent agent){
        log.info("updated-> {}",agent);
        service.addAgent(agent);
    }

    @GetMapping("/search-by-id/{id}")
    public Agent getAgentById(@PathVariable Integer id){
        return service.searchAgentById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAgentById(@PathVariable Integer id){
        service.deleteAgentById(id);
    }
    @PutMapping("/update-agent")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAgent(@RequestBody Agent agent){
        service.updateAgentById(agent);
    }
}
