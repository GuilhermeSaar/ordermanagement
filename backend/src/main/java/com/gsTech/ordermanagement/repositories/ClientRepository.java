package com.gsTech.ordermanagement.repositories;

import com.gsTech.ordermanagement.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long > {

}
