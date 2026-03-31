package com.producto.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private int id_producto;

    @NotBlank(message = "El nombre del producto no puede estar vacio")
    private String nombre_producto;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private double precio;

    @NotNull(message = "El stock no puede estar vacio")
    @Positive(message = "El numero no puede ser menor a cero")
    private int stock;

    // @Positive permite que el valor de la variable no pueda ser negativo
}
