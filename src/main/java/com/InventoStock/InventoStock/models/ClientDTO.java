package com.InventoStock.InventoStock.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientDTO {

    @NotNull(message = "Name should not be null")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotNull(message = "Last name should not be null")
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @Size(min = 11, max = 11, message = "CPF should have 11 numbers")
    @NotNull(message = "CPF should not be null")
    @NotEmpty(message = "CPF should not be empty")
    private String cpf;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "E-mail is invalid")
    @NotNull(message = "Email should not be null")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotNull(message = "Phone should not be null")
    @NotEmpty(message = "Phone should not be empty")
    private String phone;

    private Address address;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
