package com.gsTech.ordermanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Double price;
    private int quantityStock;

    // constructos
    public Product(long id, String name, String description, Double price, int quantityStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }
}
