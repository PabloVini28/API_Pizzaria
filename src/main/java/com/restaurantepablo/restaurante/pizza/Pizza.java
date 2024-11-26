package com.restaurantepablo.restaurante.pizza;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean disponivel;
    private double preco;
    @Enumerated(EnumType.STRING)
    private Sabor sabor;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    

}
