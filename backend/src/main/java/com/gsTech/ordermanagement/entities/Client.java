package com.gsTech.ordermanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // gerado automaticamente
    private String name; // obrigatorio e minimo de 3 caracteres
    private String email; // obrigatorio e unico
    private LocalDate birthDate;
    //private LocalDate registrationDate;  // preenchido automaticamente ao criar o client;


    // constructors

    public Client(long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;

    }

    // default

    public Client() {
    }


    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

//    public LocalDate getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDate registrationDate) {
//        this.registrationDate = registrationDate;
//    }
}
