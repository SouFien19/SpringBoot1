package com.example.firstapp.Repository.Agent;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository extends JpaRepository<Agent,Long>, AgentRepositoryCostum {
}