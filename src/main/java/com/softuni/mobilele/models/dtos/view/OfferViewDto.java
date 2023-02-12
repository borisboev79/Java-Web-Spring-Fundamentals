package com.softuni.mobilele.models.dtos.view;

import com.softuni.mobilele.models.enums.EngineType;
import com.softuni.mobilele.models.enums.TransmissionType;

import java.math.BigDecimal;
import java.time.Year;

public class OfferViewDto {
    private String imageUrl;

    private Year year;

    private String model;

    private String brand;

    private Integer mileage;

    private BigDecimal price;

    private EngineType engine;

    private TransmissionType transmission;

    private String description;

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public OfferViewDto setYear(Year year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferViewDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferViewDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferViewDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public OfferViewDto setEngine(EngineType engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public OfferViewDto setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferViewDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
