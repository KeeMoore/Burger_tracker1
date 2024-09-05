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
    public Burger updateBurger (Long id, Burger burger) {
        Optional<Burger> optionalBurger = this.burgerRepository.findById(id);
        if (optionalBurger.isPresent()) {
            Burger burgerToUpdate = optionalBurger.get();
            burgerToUpdate.setBurgerName(burger.getBurgerName());
            burgerToUpdate.setRestaurantName(burger.getRestaurantName());
            burgerToUpdate.setRating(burger.getRating());
            burgerToUpdate.setNotes(burger.getNotes());
            return burgerRepository.save(burgerToUpdate);
        }
        return null;
    }

    public Burger findBurgerById(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }


}
