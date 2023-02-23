package com.softuni.mobilele.web;


import com.softuni.mobilele.models.dtos.model.OfferServiceModel;
import com.softuni.mobilele.models.enums.EngineType;
import com.softuni.mobilele.models.enums.TransmissionType;
import com.softuni.mobilele.services.brand.BrandService;
import com.softuni.mobilele.services.offers.OfferService;
import com.softuni.mobilele.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OffersController extends BaseController {
    private final OfferService offerService;
    private final BrandService brandService;
    private final UserService userService;


    public OffersController(OfferService offerService, BrandService brandService, UserService userService) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getOffers(Model model) {
        model.addAttribute("offers", this.offerService.getAllOffers());
        return "offers";
    }

    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel() {
        return new OfferServiceModel();
    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", EngineType.values());
        model.addAttribute("transmissions", TransmissionType.values());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferServiceModel offerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerModel", offerModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/add";
        }
        Long newOfferID = this.offerService.saveOffer(offerModel);

        return "redirect:/offers/offer/" + newOfferID;
    }

    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable Long id, Model model) {

        model.addAttribute("offer", this.offerService.findById(id));

        return "/details";
    }

    @PostMapping("/users/logout")
    public String logout(){
        userService.logoutCurrentUser();
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateOffer(@PathVariable Long id, Model model) {

        model.addAttribute("offer", this.offerService.findById(id));

        return "/update";

    }

    @DeleteMapping("/offer/{id}")
    public String delete(@PathVariable Long id) {

        offerService.delete(id);

        return "redirect:/offers/all";
    }
}
