package com.restaurantepablo.restaurante.pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{ // <Entidade, tipo do Id>
    
}
