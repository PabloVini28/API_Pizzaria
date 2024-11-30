package com.restaurantepablo.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantepablo.restaurante.entities.pizza.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{ // <Entidade, tipo do Id>
    
}
