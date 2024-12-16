package com.gsTech.ordermanagement.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private LocalDate orderData; // preenchido automaticamente

    @ManyToOne
    private Client client;
    private Double totalValue;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> itens = new ArrayList<>();

    // constructors
    public Order(UUID id, LocalDate orderData, Client client, Double totalValue) {
        this.id = id;
        this.orderData = orderData;
        this.client = client;
        this.totalValue = totalValue;
    }

    public Order() {
    }

    // calcular valor total
    public BigDecimal calculateTotalValue() {

        return itens.stream()
                .map(OrderItem::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDate orderData) {
        this.orderData = orderData;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<OrderItem> getItens() {
        return itens;
    }


}
