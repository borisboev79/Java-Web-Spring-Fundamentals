package com.softuni.mobilele.models.entities;

import com.softuni.mobilele.models.enums.EngineType;
import com.softuni.mobilele.models.enums.TransmissionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineType engine;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    @Column(nullable = false)
    private Year year;

    @ManyToOne(optional = false)
    private Model model;

    @ManyToOne(optional = false)
    private User seller;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public Offer setEngine(EngineType engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public Offer setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public Offer setYear(Year year) {
        this.year = year;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public Offer setModel(Model model) {
        this.model = model;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
