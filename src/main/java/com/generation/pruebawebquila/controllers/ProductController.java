package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.ProductEntity;
import com.generation.pruebawebquila.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*") //nos permite indicar que nos permite tomar peticiones de cualquier lado
@RequestMapping("/producto") //esta anotación nos permite identificar el enrutamiento base

public class ProductController {

    @Autowired //inyección de dependencia
    private ProductServiceImpl productService;

    @GetMapping("/listaProducto")
    public List<ProductEntity> obtenerProductos(){
        return productService.obtenerProductos();
    }

    @GetMapping("obtener/{id}")
    public ResponseEntity<ProductEntity> obtenerProductoPorId(@PathVariable Long id){
        Optional<ProductEntity> optionalProduct = productService.obtenerProductoPorId(id);
        return optionalProduct
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<ProductEntity> guardarProducto(@RequestBody ProductEntity productEntity){
        ProductEntity savedProduct = productService.guardarProducto(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarProductoPorId(@PathVariable Long id) {

        productService.borrarProductoPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProductEntity> editarProductoPorId(@PathVariable Long id, @RequestBody ProductEntity productEdit){
        ProductEntity editedProduct = productService.editarProductoPorId(id, productEdit);
        if (editedProduct != null){
            return ResponseEntity.ok().body(editedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
