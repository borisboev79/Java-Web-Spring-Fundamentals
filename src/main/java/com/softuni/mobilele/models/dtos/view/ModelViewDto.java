package com.softuni.mobilele.models.dtos.view;

public class ModelViewDto {

    private Long id;

    private String name;

    private String category;

    private Integer startYear;

    private Integer endYear;

    private String imageUrl;

    public String getName() {
        return name;
    }

    public ModelViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ModelViewDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelViewDto setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelViewDto setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ModelViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
