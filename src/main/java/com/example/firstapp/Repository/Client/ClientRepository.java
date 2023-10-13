package com.example.firstapp.Repository.Client;

import com.example.firstapp.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>, ClientRepositoryCostum {


}
