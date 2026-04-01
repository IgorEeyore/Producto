package com.producto.service;


import com.producto.model.Producto;
import com.producto.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Metodo para tener todos los productos
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    // Metodo para obtener los productos por id
    public Producto getProductoById(int id_producto){
        Optional<Producto> producto = productoRepository.findById(id_producto);
        return producto.orElseThrow(() -> new RuntimeException("No se encontro el producto con la ID " + id_producto));
    }

    // Metodo para guardar un productos
    public Producto saveProducto(Producto pro){
        return productoRepository.save(pro);
    }

    // Metodo para actualizar un producto
    public Producto updateProducto(Producto pro){
        return productoRepository.save(pro);
    }

    // Metodo para borrar un producto
    public void deleteProducto(int id_producto){
        productoRepository.deleteById(id_producto);
    }
}
