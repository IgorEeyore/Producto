package com.producto.repository;


import com.producto.model.Producto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    private Integer contadorId = 1;

    public ProductoRepository(){
        listaProductos.add(new Producto(contadorId++,"Teclado",15000.0,25));
        listaProductos.add(new Producto(contadorId++,"Mouse",8000.0,16));
        listaProductos.add(new Producto(contadorId++,"Monitor",26000.0,12));
    }

    public List<Producto> getAllProducto(){
        return listaProductos;
    }

    public Producto saveProducto(Producto pro){
        listaProductos.add(pro);
        return pro;
    }

    public Producto updateProducto(Producto pro){
        int id_producto = 0;
        int posicion = 0;

        for(int i = 0;i<listaProductos.size();i++){
            if(listaProductos.get(i).getId_producto() == pro.getId_producto()){
                id_producto = pro.getId_producto();
                posicion = i;
            }
        }

        Producto producto1 = new Producto();
        producto1.setId_producto(id_producto);
        producto1.setNombre_producto(pro.getNombre_producto());
        producto1.setPrecio(pro.getPrecio());
        producto1.setStock(pro.getStock());

        listaProductos.set(posicion,producto1);
        
        return producto1;
    }

    public void deleteProducto(int id_producto){
        Producto producto = getProductoById(id_producto);
        if (producto != null) {
            listaProductos.remove(id_producto);
        }
    }

    public Producto getProductoById(int id_producto){
        for(Producto producto : listaProductos){
            if (producto.getId_producto() == id_producto) {
                return producto;
            }
        }
        return null;
    }
}
