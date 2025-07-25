package edu.sliit.repository;

import edu.sliit.entity.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<AgentEntity,Integer> {
}
