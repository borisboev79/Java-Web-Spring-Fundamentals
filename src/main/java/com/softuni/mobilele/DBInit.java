package com.softuni.mobilele;

import com.softuni.mobilele.models.entities.Brand;
import com.softuni.mobilele.repositories.BrandRepository;
import com.softuni.mobilele.repositories.ModelRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public DBInit(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Brand> allBrands = new ArrayList<>();
        Brand fordBrand = new Brand();
        Brand hondaBrand = new Brand("Honda");
        allBrands.add(hondaBrand);
        brandRepository.save(hondaBrand);


       /* fordBrand.setName("Ford")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        allBrands.add(fordBrand);



        Brand renaultBrand = new Brand();
        renaultBrand.setName("Renault")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        allBrands.add(renaultBrand);

        brandRepository.saveAll(allBrands);*/
    }
}
