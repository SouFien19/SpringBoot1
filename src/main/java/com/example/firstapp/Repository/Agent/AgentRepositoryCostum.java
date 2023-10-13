package com.example.firstapp.Repository.Agent;

import org.aspectj.weaver.loadtime.Agent;

public interface AgentRepositoryCostum {
    Agent getAgentByNom(String nom);
}