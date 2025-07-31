package edu.sliit.service.impl;

import edu.sliit.dto.Agent;
import edu.sliit.entity.AgentEntity;
import edu.sliit.repository.AgentRepository;
import edu.sliit.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Agent> getAll() {
        List<Agent> agentArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            agentArrayList.add(mapper.map(entity, Agent.class));
        });
        return agentArrayList;
    }

    @Override
    public void addAgent(Agent agent) {
        System.out.println(agent);
        repository.save(mapper.map(agent, AgentEntity.class));
    }

    @Override
    public void deleteAgentById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Agent searchAgentById(Integer id) {
        return repository.findById(id)
                .map(entity -> mapper.map(entity, Agent.class))
                .orElse(null);
    }

    @Override
    public void updateAgentById(Agent agent) {
        repository.save(mapper.map(agent, AgentEntity.class));
    }
}
