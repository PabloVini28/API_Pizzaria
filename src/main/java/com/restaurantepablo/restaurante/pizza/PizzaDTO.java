package com.restaurantepablo.restaurante.pizza;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
    private String nome;
    private boolean disponivel;
    private double preco;
    private Sabor sabor;
    private Tamanho tamanho;
}
