package com.InventoStock.InventoStock.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sell")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kindPayment;

    private float totalValue;

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKindPayment() {
        return kindPayment;
    }

    public void setKindPayment(String kindPayment) {
        this.kindPayment = kindPayment;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
