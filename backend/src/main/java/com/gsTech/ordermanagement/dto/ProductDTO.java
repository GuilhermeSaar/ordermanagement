package com.gsTech.ordermanagement.dto;

import com.gsTech.ordermanagement.entities.Product;
import jakarta.validation.constraints.*;


public class ProductDTO {

    private long id;

    @NotBlank(message = "Insira pelo menos 2 letras;")
    @Size(min = 2, max = 50, message = "O produto deve ter mais de 2 letras;")
    private String name;
    @NotNull
    private String description;
    @Positive(message = "Valor deve ser positivo;")
    private Double price;
    @Positive
    @Min(value = 1, message = "Deve ter pelo menos 1 produto no estoque;")
    private int quantityStock;


    // constructors
    public ProductDTO(long id, String name, String description, Double price, int quantityStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        quantityStock = product.getQuantityStock();
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
