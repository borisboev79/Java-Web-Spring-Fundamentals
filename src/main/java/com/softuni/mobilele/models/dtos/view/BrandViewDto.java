package com.softuni.mobilele.models.dtos.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewDto {

    private String name;

    private List<ModelViewDto> models;

    public String getName() {
        return name;
    }

    public BrandViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewDto> getModels() {
        return models;
    }

    public BrandViewDto setModels(List<ModelViewDto> models) {
        this.models = models;
        return this;
    }

    @Override
    public String toString() {
        return "Brand:" + name + '\'' + System.lineSeparator() +
                "Models: " + models;
    }
}
