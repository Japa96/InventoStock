package com.InventoStock.InventoStock.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sell")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ManyToMany
    private List<Product>productList;
    @Column
    @ManyToMany
    private List<Client> clientList;
    @Column
    @ManyToMany
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @Column
    private String kindPayment;
    @Column
    private float totalValue;
    @Column
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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
