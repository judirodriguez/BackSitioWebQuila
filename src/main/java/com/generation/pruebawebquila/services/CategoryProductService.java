package com.generation.pruebawebquila.services;


import com.generation.pruebawebquila.entities.CategoryProductEntity;


import java.util.List;
import java.util.Optional;

public interface CategoryProductService {
    List<CategoryProductEntity> obtenerCategoriasProducto();
    Optional<CategoryProductEntity> obtenerCategoriaPorId(Long id);
    CategoryProductEntity guardarCategoriaProducto(CategoryProductEntity categoryProductEntity);
    void borrarCategoriaProductoPorId(Long id);
    CategoryProductEntity editarCategoriaProductoPorId(Long id, CategoryProductEntity categoryProductEntity);


}
