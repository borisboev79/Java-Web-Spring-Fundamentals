package com.softuni.mobilele.services.brand;

import com.softuni.mobilele.models.dtos.view.BrandViewDto;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface BrandService extends DataBaseInitServiceService {
    List<BrandViewDto> getAllBrands();

}
