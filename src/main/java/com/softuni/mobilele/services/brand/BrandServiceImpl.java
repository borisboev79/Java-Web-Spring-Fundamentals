package com.softuni.mobilele.services.brand;

import com.softuni.mobilele.models.dtos.view.BrandViewDto;
import com.softuni.mobilele.models.dtos.view.ModelViewDto;
import com.softuni.mobilele.models.entities.Brand;
import com.softuni.mobilele.models.entities.Model;
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
public class BrandServiceImpl implements BrandService, DataBaseInitServiceService {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper mapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper mapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.mapper = mapper;
    }


    @Override
    public List<BrandViewDto> getAllBrands() {

        final List<BrandViewDto> allBrands = this.brandRepository.findAll()
                .stream().map(brand -> mapper.map(brand, BrandViewDto.class))
                .toList();

        allBrands.forEach(brand -> brand.setModels(
                findModelsByBrand(brand.getName())
                        .stream()
                        .map(model -> mapper.map(model, ModelViewDto.class))
                        .toList()
        ));


        return allBrands;

    }

    private List<Model> findModelsByBrand(String name) {

        return this.modelRepository.findAll()
                .stream().filter(model -> model.getBrand().getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<Brand> brands = new ArrayList<>();

            brands.add(new Brand().setName("Renault"));
            brands.add(new Brand("Peugeot"));
            brands.add(new Brand("Dacia"));

            this.brandRepository.saveAllAndFlush(brands);
        }
    }

    @Override
    public boolean isDbInit() {
        return brandRepository.count() > 0;
    }
}
