package com.example.firstapp.Repository.Agent;

import com.example.firstapp.Entity.Agent; // Import the correct Agent entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>, AgentRepositoryCostum {
    // Define custom repository methods, if needed
}
