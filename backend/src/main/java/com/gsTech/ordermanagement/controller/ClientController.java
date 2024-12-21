package com.gsTech.ordermanagement.controller;


import com.gsTech.ordermanagement.dto.ClientDTO;
import com.gsTech.ordermanagement.entities.Client;
import com.gsTech.ordermanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAllClients(Pageable pageable) {

        Page<Client> result = clientService.findAllClients(pageable);
        Page<ClientDTO> resultDTO = result.map(ClientDTO::new);

        return ResponseEntity.ok().body(resultDTO);

    }

}
