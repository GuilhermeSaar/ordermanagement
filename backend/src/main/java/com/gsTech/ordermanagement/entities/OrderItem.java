package com.gsTech.ordermanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    @Min(value = 1)
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalValue;

    // constructors
    public OrderItem(Long id, Product product, Order order, int quantity, BigDecimal unitPrice) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderItem() {

    }

    // methods
    public void prePersist() {
        this.unitPrice = BigDecimal.valueOf(product.getPrice());
        this.totalValue = calculateTotalValue();
    }

    public BigDecimal calculateTotalValue() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // getters and setters
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalValue = calculateTotalValue(); // Recalcula o valor total ao alterar a quantidade
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        this.totalValue = calculateTotalValue(); // Recalcula o valor total ao alterar o preço unitário
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }



}
