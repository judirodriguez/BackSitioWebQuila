package com.generation.pruebawebquila.services;


import com.generation.pruebawebquila.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductEntity> obtenerProductos(); //obtener todos los productos
    Optional<ProductEntity> obtenerProductoPorId(Long id); // obtener producto por id
    ProductEntity guardarProducto(ProductEntity productEntity); //guardar productos
    void borrarProductoPorId(Long id);// Borrar
    ProductEntity editarProductoPorId(Long id, ProductEntity productEntity); //editar productos por id




}
