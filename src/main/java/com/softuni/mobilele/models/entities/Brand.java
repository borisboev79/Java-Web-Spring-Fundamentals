package com.softuni.mobilele.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;


    public Brand(String name) {
        this.name = name;
    }

    public Brand(){}

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
