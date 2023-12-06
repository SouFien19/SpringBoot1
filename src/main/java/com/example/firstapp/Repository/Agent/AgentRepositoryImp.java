package com.example.firstapp.Repository.Agent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.loadtime.Agent;

public class AgentRepositoryImp implements AgentRepositoryCostum{
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Agent getAgentByNom(String Nom) {
        Query query = entityManager.createNativeQuery("SELECT ag.* FROM Agent ag" + "WHERE ag.nom LIKE ?", Agent.class);
        query.setParameter(1, Nom + "%");
        return (Agent) query.getSingleResult();
    }
}
