package edu.sliit.service;

import edu.sliit.dto.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAll();

    void addAgent(Agent agent);

    void deleteAgentById(Integer id);

    Agent searchAgentById(Integer id);

    void updateAgentById(Agent agent);
}
