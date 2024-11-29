package com.restaurantepablo.restaurante.pizza;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
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

    public List<PizzaDTO> buscarTodos(){
        //convertendo lista em entidade
        return pizzaRepository.findAll().stream().map(p -> modelMapper.map(p,PizzaDTO.class)).
        collect(Collectors.toList());
    }

    public PizzaDTO buscarPorID(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        //converter entidade em dto
        return modelMapper.map(pizza, PizzaDTO.class);
    }

    public PizzaDTO atualizarPizza(Long id,PizzaDTO dto) {
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizza.setId(id);
        pizza = pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaDTO.class);
    }

    
}
