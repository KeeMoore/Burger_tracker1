package com.kmoore.burgertracker1.controllers;

import com.kmoore.burgertracker1.models.Burger;
import com.kmoore.burgertracker1.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/burgers/edit/{id}")
    public String editBurger(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.findBurgerById(id);
        model.addAttribute("burger", burger);
        return "edit.jsp";
    }

    @PostMapping("/burgers/update/{id}")
    public String updateBurger(@PathVariable("id") Long id, @Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        burgerService.updateBurger(id, burger);
        return "redirect:/";
    }
    @PutMapping("/burgers/update/{id}")
    public String updateBurger(@Valid @ModelAttribute Burger burger, @PathVariable(value = "id") Long id,  BindingResult result, ch.qos.logback.core.model.Model model) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        this.burgerService.updateBurger(id, burger);
        return "redirect:/burgers";
    }
}







