package com.example.firstapp.Repository.Model;

import com.example.firstapp.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long>,ModelRepositoryCustom{
}