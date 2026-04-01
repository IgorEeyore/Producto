package com.producto.controller;


import com.producto.model.Producto;
import com.producto.service.ProductoService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

// Estos imports son para el crud de la maquina
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Estos para los @ antes de la clase
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Estos para los parametros en los metodos del crud
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

// Para dar una respuesta solida a una solicitud
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/v1/productos") // La direccion de la api para el postman
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    Map<String,Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<?> getProducto(){
        List<Producto> productos = productoService.getProductos();

        if (productos == null || productos.isEmpty()) {
            response.put("timestamp", LocalDateTime.now());
            response.put("status", HttpStatus.NO_CONTENT.value());
            response.put("message", "No hay productos registrados");
            response.put("data", null);
            return ResponseEntity.ok(response);
        }
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("data", productos);

        return ResponseEntity.ok(response);
    } 

    @GetMapping("{id_producto}")
    public ResponseEntity<?> getProductoById(@PathVariable int id_producto){
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("data", productoService.getProductoById(id_producto));

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("data", productoService.saveProducto(producto));

        return ResponseEntity.ok(response);
    }
    
    @PutMapping("{id_producto}")
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto, @PathVariable int id_producto){
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("data", productoService.updateProducto(producto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id_producto}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id_producto){
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Producto eliminado correctamente");
        response.put("data", null);

        return ResponseEntity.ok(response);
    }
}
