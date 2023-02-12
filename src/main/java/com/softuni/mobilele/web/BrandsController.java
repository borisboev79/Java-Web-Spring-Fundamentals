package com.softuni.mobilele.web;

import com.softuni.mobilele.services.brand.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController extends BaseController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getBrands(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        return "brands";
    }
}
