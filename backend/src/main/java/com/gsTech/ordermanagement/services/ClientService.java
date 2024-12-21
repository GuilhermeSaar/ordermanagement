package com.gsTech.ordermanagement.services;

import com.gsTech.ordermanagement.entities.Client;
import com.gsTech.ordermanagement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    //dados paginados
    public Page<Client> findAllClients(Pageable pageable) {

        return clientRepository.findAll(pageable);

    }




}
