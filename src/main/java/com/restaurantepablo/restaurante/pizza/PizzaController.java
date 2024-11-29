package com.restaurantepablo.restaurante.pizza;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public void cadastrar(@Valid @RequestBody PizzaDTO dto){
     pizzaService.criarPizza(dto);   
    }

    @GetMapping
    public List<PizzaDTO> buscarTodos(){
        return pizzaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PizzaDTO buscarPorID(@PathVariable @NotNull Long id) {
        return pizzaService.buscarPorID(id);
    }

    @PutMapping("/{id}")
    public PizzaDTO atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PizzaDTO dto) {
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id,dto);
        return pizzaAtualizada;
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable @NotNull Long id){
        pizzaService.excluir(id);
    }
    



}
