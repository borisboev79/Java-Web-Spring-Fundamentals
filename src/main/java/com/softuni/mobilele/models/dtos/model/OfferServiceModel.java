package com.softuni.mobilele.models.dtos.model;

import com.softuni.mobilele.models.entities.BaseEntity;
import com.softuni.mobilele.models.enums.EngineType;
import com.softuni.mobilele.models.enums.TransmissionType;
import com.softuni.mobilele.validation.YearPastOrPresent;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OfferServiceModel {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin("100")
    private BigDecimal price;

    @NotNull
    private EngineType engine;

    @NotNull
    private TransmissionType transmission;

    @NotNull
    @Positive
    private Integer mileage;

    @NotNull
    @YearPastOrPresent(minYear = 1930)
    private Integer year;

    @NotEmpty
    @Size(min = 10, max = 1000)
    private String description;

    @NotEmpty
    private String imageUrl;

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(EngineType engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "price=" + price +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", mileage=" + mileage +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
