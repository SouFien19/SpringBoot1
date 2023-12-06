package com.example.firstapp.Repository.Model;


import com.example.firstapp.Entity.Modeles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ModelRepositoryImp implements ModelRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Modeles getModelByNom(String nom){
        Query query=entityManager.createNativeQuery("SELECT m.* FROM Model m"+
                "WHERE m.nom LIKE ?", Modeles.class);
        query.setParameter(1,nom+"%");
        return (Modeles) query.getSingleResult();
    }
}