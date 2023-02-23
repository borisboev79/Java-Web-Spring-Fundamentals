package com.softuni.mobilele.web;

import com.softuni.mobilele.services.brand.BrandService;
import com.softuni.mobilele.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController extends BaseController {
    private final BrandService brandService;
    private final UserService userService;

    public BrandsController(BrandService brandService, UserService userService) {
        this.brandService = brandService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getBrands(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        return "brands";
    }

    @PostMapping("/users/logout")
    public String logout(){
        userService.logoutCurrentUser();
        return "redirect:/";
    }
}
