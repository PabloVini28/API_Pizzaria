package com.restaurantepablo.restaurante.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.restaurantepablo.restaurante.dtos.PizzaDTO;
import com.restaurantepablo.restaurante.entities.pizza.Pizza;
import com.restaurantepablo.restaurante.repositories.PizzaRepository;

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

    public Page<PizzaDTO> buscarTodos(Pageable paginacao){
        //convertendo lista em entidade
        return pizzaRepository.findAll(paginacao).map(p->modelMapper.map(p,PizzaDTO.class));
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

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }

    
}
