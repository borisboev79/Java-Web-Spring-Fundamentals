package com.softuni.mobilele.services.role;

import com.softuni.mobilele.models.dtos.view.RoleViewDto;
import com.softuni.mobilele.models.entities.Role;
import com.softuni.mobilele.models.enums.RoleType;
import com.softuni.mobilele.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.dbInit();
    }

    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<Role> roles = new ArrayList<>();

            roles.add(new Role().setRole(RoleType.USER));
            roles.add(new Role().setRole(RoleType.ADMIN));

            this.roleRepository.saveAllAndFlush(roles);
        }

    }

    @Override
    public boolean isDbInit() {
        return this.roleRepository.count() > 0;
    }

    @Override
    public List<RoleViewDto> getAll() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, RoleViewDto.class))
                .collect(Collectors.toList());
    }
}

