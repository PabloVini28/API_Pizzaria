package com.restaurantepablo.restaurante.pizza;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    public PizzaDTO criarPizza(PizzaDTO dto) {
        //convertendo dto em pizza-entidade
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizzaRepository.save(pizza);

        // convertendo pizza-entidade em dto
        return modelMapper.map(pizza, PizzaDTO.class);
    }

    
}
