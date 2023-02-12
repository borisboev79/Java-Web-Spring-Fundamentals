package com.softuni.mobilele.web;

import com.softuni.mobilele.models.dtos.model.UserLoginServiceModel;
import com.softuni.mobilele.security.CurrentUser;
import com.softuni.mobilele.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserLoginServiceModel userModel(){
        return new UserLoginServiceModel();
    }

    @GetMapping("/users/login")
    public String showLogin(){
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(@Valid @ModelAttribute UserLoginServiceModel userModel, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/login";
        }



        if(this.userService.authenticate(userModel.getUsername(), userModel.getPassword())){
            userService.loginUsername(userModel.getUsername());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String logout(){
        userService.logoutCurrentUser();
        return "redirect:/";
    }
}
