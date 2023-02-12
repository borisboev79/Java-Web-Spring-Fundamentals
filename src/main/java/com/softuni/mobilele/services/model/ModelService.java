package com.softuni.mobilele.services.model;

import com.softuni.mobilele.models.dtos.view.ModelViewDto;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface ModelService extends DataBaseInitServiceService {
    List<ModelViewDto> getAllModels();
}
