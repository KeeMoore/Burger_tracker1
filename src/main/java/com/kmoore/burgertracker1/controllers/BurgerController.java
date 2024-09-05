package com.kmoore.burgertracker1.controllers;

import com.kmoore.burgertracker1.models.Burger;
import com.kmoore.burgertracker1.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BurgerController {
    @Autowired
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
        model.addAttribute("burgers", burgerService.allBurgers());
        return "redirect:/burgers";
    }

    @GetMapping("/burgers")
    public String index(Model model, @ModelAttribute Burger burger) {
        model.addAttribute("burgers", burgerService.allBurgers());
        model.addAttribute("burger", burger);
        return "index.jsp";
    }


    @PostMapping("/burgers/create")
    public String addBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Errors"); // Debug statement
            model.addAttribute("burgers", burgerService.allBurgers());
            return "index.jsp";
        }
        System.out.println("Adding burger: " + burger); // Debug statement
        burgerService.createBurger(burger);
        return "redirect:/";
    }
}







