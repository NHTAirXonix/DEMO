package com.example.springmaven.dto;

import com.example.springmaven.model.Product;
import lombok.*;

import java.util.Set;


public class PersonDto {

    private Long id;
    private String name;
    private String position;
    private Set<Product> productSet;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
