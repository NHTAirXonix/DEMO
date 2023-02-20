package com.example.springmaven.model;



import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Generated
@Entity
public class Person {

    @Id
    @GeneratedValue
    @Column()
    private Long id;
    private String name;
    private String position;

    @OneToMany(mappedBy = "person")
    private Set<Product> productSet;


    public Person() {
    }

    public Person(Long id, String name, String position, Set<Product> productSet) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.productSet = productSet;
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
