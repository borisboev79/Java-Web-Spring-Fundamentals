package com.softuni.mobilele.models.dtos.model;

import com.softuni.mobilele.validation.YearPastOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OfferServiceModel {

    @NotNull
    private Long modelId;

    @NotNull
    @Min(100)
    private BigDecimal price;

    @NotNull
    private String engine;

    @NotNull
    private String transmission;

    @NotNull
    @Positive
    private Integer mileage;

    @NotNull
    @YearPastOrPresent(minYear = 1930)
    private Integer year;

    @NotNull
    @Size(min = 10, max = 1000)
    private String description;

    @NotNull
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(String transmission) {
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

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "modelId=" + modelId +
                ", price=" + price +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
