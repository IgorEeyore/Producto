package com.producto.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @NotBlank(message = "El nombre del producto no puede estar vacio")
    @Column(nullable = false)
    private String nombre_producto;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    @Column(nullable = false)
    private double precio;

    @NotNull(message = "El stock no puede estar vacio")
    @Positive(message = "El numero no puede ser menor a cero")
    @Column(nullable = false)
    private int stock;
    // @Positive permite que el valor de la variable no pueda ser negativo

    // NUEVO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Producto(String nombre_producto, Double precio, int stock){
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre_producto, Double precio, int stock, Categoria categoria){
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
}
