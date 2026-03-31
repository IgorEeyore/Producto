package com.producto.service;


import com.producto.model.Producto;
import com.producto.repository.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Metodo para tener todos los productos
    public List<Producto> getProductos(){
        return productoRepository.getAllProducto();
    }

    // Metodo para obtener los productos por id
    public Producto getProductoById(int id_producto){
        return productoRepository.getProductoById(id_producto);
    }

    // Metodo para guardar un productos
    public Producto saveProducto(Producto pro){
        return productoRepository.saveProducto(pro);
    }

    // Metodo para actualizar un producto
    public Producto updateProducto(Producto pro){
        return productoRepository.updateProducto(pro);
    }

    // Metodo para borrar un producto
    public String deleteProducto(int id_producto){
        productoRepository.deleteProducto(id_producto);
        return "Producto eliminado";
    }
}
