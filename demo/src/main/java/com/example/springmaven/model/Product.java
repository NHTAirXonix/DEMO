package com.example.springmaven.model;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    @NotBlank(message = "Can not blank or empty")
    private String name;

    @Column(name = "product_price")
    @NotBlank(message = "Can not blank or empty")
    private String price;

    @Column(name = "product_detail")
    @NotBlank(message = "Can not blank or empty")
    private String detail;

    @Column(name = "product_manufacturer")
    @NotBlank(message = "Can not blank or empty")
    private String manufacturer;

    @Column(name = "product_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id")
    private Person person;

    public Product() {
    }

    public Product(int id, String name, String price, String detail, String manufacturer, String status, Person person) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacturer = manufacturer;
        this.status = status;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
