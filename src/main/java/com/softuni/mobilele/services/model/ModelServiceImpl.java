package com.softuni.mobilele.services.model;

import com.softuni.mobilele.models.dtos.view.ModelViewDto;
import com.softuni.mobilele.models.entities.Model;
import com.softuni.mobilele.models.enums.CategoryName;
import com.softuni.mobilele.repositories.BrandRepository;
import com.softuni.mobilele.repositories.ModelRepository;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService, DataBaseInitServiceService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper mapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper mapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ModelViewDto> getAllModels() {
        return this.modelRepository.findAll()
                .stream()
                .map(model -> mapper.map(model, ModelViewDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<Model> models = new ArrayList<>();
            models.add(new Model()
                    .setName("Clio")
                    .setCategory(CategoryName.CAR)
                    .setBrand(brandRepository.findFirstByName("Renault").get())
                    .setStartYear(1990)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/2019_Renault_Clio_Iconic_TCE_1.0_Front.jpg/1920px-2019_Renault_Clio_Iconic_TCE_1.0_Front.jpg"));

            models.add(new Model()
                    .setName("Trafic")
                    .setCategory(CategoryName.BUS)
                    .setBrand(brandRepository.findFirstByName("Renault").get())
                    .setStartYear(1980)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/2018_Renault_Trafic_SL27_Business%2B_Energy_1.6_Front.jpg/420px-2018_Renault_Trafic_SL27_Business%2B_Energy_1.6_Front.jpg"));

            models.add(new Model()
                    .setName("208")
                    .setCategory(CategoryName.CAR)
                    .setBrand(brandRepository.findFirstByName("Peugeot").get())
                    .setStartYear(2012)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/2020_Peugeot_208_GT_Line_PureTech_1.2_Front.jpg/420px-2020_Peugeot_208_GT_Line_PureTech_1.2_Front.jpg"));

            models.add(new Model()
                    .setName("Quark")
                    .setCategory(CategoryName.MOTORCYCLE)
                    .setBrand(brandRepository.findFirstByName("Peugeot").get())
                    .setStartYear(2004)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/c/c4/Peugeot_quark_by_jens_martin_schlatter.JPG"));

            models.add(new Model()
                    .setName("Spring")
                    .setCategory(CategoryName.CAR)
                    .setBrand(brandRepository.findFirstByName("Dacia").get())
                    .setStartYear(2021)
                    .setImageUrl("https://www.dacia.bg/CountriesData/Bulgaria/images/packshots/spring_ig_w320_h200.png"));


            modelRepository.saveAllAndFlush(models);
        }

    }

    @Override
    public boolean isDbInit() {
        return this.modelRepository.count() > 0;
    }
}


