package com.restaurantepablo.restaurante.controllers;


import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantepablo.restaurante.dtos.PizzaDTO;
import com.restaurantepablo.restaurante.services.PizzaService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<PizzaDTO> cadastrar(@Valid @RequestBody PizzaDTO dto, UriComponentsBuilder uriBuilder){
        PizzaDTO pizzaDTO = pizzaService.criarPizza(dto);   
        URI endereco = uriBuilder.path("/pizzas/{id}").buildAndExpand(pizzaDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(pizzaDTO);
    }

    @GetMapping
    public ResponseEntity<Page<PizzaDTO>> buscarTodos(@PageableDefault(size = 10) Pageable paginacao){
        Page<PizzaDTO> pizzas = pizzaService.buscarTodos(paginacao);
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> buscarPorID(@PathVariable @NotNull Long id) {
        PizzaDTO pizzaDTO = pizzaService.buscarPorID(id);
        return ResponseEntity.ok(pizzaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PizzaDTO dto) {
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id,dto);
        return ResponseEntity.ok(pizzaAtualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id){
        pizzaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    



}
