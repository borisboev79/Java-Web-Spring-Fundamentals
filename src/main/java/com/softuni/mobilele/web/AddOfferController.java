package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RequestMapping("/offers")
public class AddOfferController extends BaseController{

    @GetMapping("/add")
    public ModelAndView viewAddOffers(){
        return super.view("offer-add");
    }
}
