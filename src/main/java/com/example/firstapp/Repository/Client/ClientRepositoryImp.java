package com.example.firstapp.Repository.Client;

import com.example.firstapp.Entity.Client;
import com.example.firstapp.Repository.Client.ClientRepositoryCostum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ClientRepositoryImp implements ClientRepositoryCostum {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Client getClientByNom(String Nom) {

        Query query = entityManager.createNativeQuery("SELECT C.* FROM Client c" + "WHERE C.nom LIKE ? ", Client.class);
        query.setParameter(1, Nom + "%");

        return  (Client) query.getSingleResult();
    }
}
