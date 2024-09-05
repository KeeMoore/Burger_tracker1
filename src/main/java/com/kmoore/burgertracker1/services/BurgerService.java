package com.kmoore.burgertracker1.services;

import com.kmoore.burgertracker1.models.Burger;
import com.kmoore.burgertracker1.repositories.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    @Autowired
    // adding the burger repository as a dependency
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
// returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    public Burger save(Burger burger) {
        burgerRepository.save(burger);
        return burger;
    }
    // creates a burger
    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    // updates a burger
    public Burger updateBurger (Burger burger) {
        return burgerRepository.save(burger);
    }

    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }

}
