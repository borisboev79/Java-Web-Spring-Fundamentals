package com.softuni.mobilele.services.role;

import com.softuni.mobilele.models.dtos.view.RoleViewDto;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface RoleService extends DataBaseInitServiceService {
    List<RoleViewDto> getAll();
}
