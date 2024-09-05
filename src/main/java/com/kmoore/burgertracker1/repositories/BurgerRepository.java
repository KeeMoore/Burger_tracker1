package com.kmoore.burgertracker1.repositories;

import com.kmoore.burgertracker1.models.Burger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
    // this method retrieves all the books from the database
    List<Burger> findAll();
}

