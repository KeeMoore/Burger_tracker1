package com.kmoore.burgertracker1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name ="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Burger Name must be between 2 and 100 characters")
    private String burgerName;

    @NotBlank(message = "Restaurant Name is mandatory")
    @Size(min = 2, max = 100, message = "Restaurant Name must be between 2 and 100 characters")
    private String restaurantName;


    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;

    @NotBlank
    @Size(max = 255, message = "Comments must be less than 255 characters")
    private String notes;

    public Burger(){

    }
    public Burger(String burgerName, String restaurantName, int rating, String notes, Long id) {
        this.burgerName = burgerName;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.notes = notes;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") @Size(min = 2, max = 100, message = "Burger Name must be between 2 and 100 characters") String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(@NotBlank(message = "Name is mandatory") @Size(min = 2, max = 100, message = "Burger Name must be between 2 and 100 characters") String burgerName) {
        this.burgerName = burgerName;
    }

    public @NotBlank(message = "Restaurant Name is mandatory") @Size(min = 2, max = 100, message = "Restaurant Name must be between 2 and 100 characters") String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(@NotBlank(message = "Restaurant Name is mandatory") @Size(min = 2, max = 100, message = "Restaurant Name must be between 2 and 100 characters") String restaurantName) {
        this.restaurantName = restaurantName;
    }


    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    public int getRating() {
        return rating;
    }

    public void setRating( @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must be at most 5") int rating) {
        this.rating = rating;
    }

    public @NotBlank @Size(max = 255, message = "Comments must be less than 255 characters") String getNotes() {
        return notes;
    }

    public void setNotes(@NotBlank @Size(max = 255, message = "Comments must be less than 255 characters") String notes) {
        this.notes = notes;
    }


}
