package com.softuni.mobilele.services.init;


import com.softuni.mobilele.services.brand.BrandService;
import com.softuni.mobilele.services.model.ModelService;
import com.softuni.mobilele.services.offers.OfferService;
import com.softuni.mobilele.services.role.RoleService;
import com.softuni.mobilele.services.user.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseInitServiceServiceImpl implements DataBaseInitServiceService {
    private final BrandService brandService;
    private final RoleService roleService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserService userService;

    @Autowired
    public DataBaseInitServiceServiceImpl(BrandService brandService, RoleService roleService, ModelService modelService, OfferService offerService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.roleService = roleService;
        this.userService = userService;
        this.offerService = offerService;

    }

    @PostConstruct
    public void postConstruct() {
        dbInit();
    }

    @Override
    public void dbInit() {
        // if (isDbInit()) {
        this.brandService.dbInit();
        this.modelService.dbInit();
        this.roleService.dbInit();
        this.userService.dbInit();
        this.offerService.dbInit();

        //          }
    }

    @Override
    public boolean isDbInit() {
        return false;
    }
}
