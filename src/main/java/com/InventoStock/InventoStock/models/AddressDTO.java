package com.InventoStock.InventoStock.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {

    @NotNull(message = "Street should not be null")
    @NotEmpty(message = "Street should not be empty")
    private String street;

    @NotNull(message = "Neighborhood should not be null")
    @NotEmpty(message = "Neighborhood should not be empty")
    private String neighborhood;

    @NotNull(message = "City should not be null")
    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotNull(message = "State should not be null")
    @NotEmpty(message = "State should not be empty")
    private String state;

    private String complement;

    @NotNull(message = "Zip Code should not be null")
    @NotEmpty(message = "Zip Code should not be empty")
    private String zipCode;

    @NotNull(message = "Number should not be null")
    @NotEmpty(message = "Number should not be empty")
    private int number;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
