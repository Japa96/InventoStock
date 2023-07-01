package com.InventoStock.InventoStock.models;

import java.util.List;

public class SellDTO {

    private String kindPayment;

    private float totalValue;

    private int quantity;

    private Product product;

    private Seller seller;

    private Client client;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
