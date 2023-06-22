package com.InventoStock.InventoStock.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @OneToMany(mappedBy = "seller")
    private List<Sell> sellList;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sell> getSellList() {
        return sellList;
    }

    public void setSellList(List<Sell> sellList) {
        this.sellList = sellList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
