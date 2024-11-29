package com.restaurantepablo.restaurante.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {

    private Long id;

    @NotBlank
    private String nome;

    private boolean disponivel;

    @Positive
    private double preco;

    private Sabor sabor;

    private Tamanho tamanho;
    
    @NotNull
    private Categoria categoria;
}
