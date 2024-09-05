package com.kmoore.burgertracker1.controllers;

import com.kmoore.burgertracker1.models.Burger;
import com.kmoore.burgertracker1.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BurgerApi {
    @Autowired
    private final BurgerService burgerService;

    public BurgerApi(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/burgers")
    public List<Burger> getAllBurgers() {
        return (List<Burger>) burgerService.allBurgers();
    }

    @PostMapping("/burgers")
    public Burger createBurger(@Valid @RequestBody Burger burger) {
        return burgerService.save(burger);
    }
}
