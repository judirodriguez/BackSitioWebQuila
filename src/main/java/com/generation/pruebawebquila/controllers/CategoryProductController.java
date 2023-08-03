package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.CategoryProductEntity;
import com.generation.pruebawebquila.services.CategoryProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoriaProducto")

public class CategoryProductController {

    @Autowired
    private CategoryProductServiceImpl categoryProductService;

    @GetMapping("/listaCategoria")
    public List<CategoryProductEntity> obtenerCategoriasProducto(){
        return categoryProductService.obtenerCategoriasProducto();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<CategoryProductEntity> obtenerCategoriaProductoPorId(@PathVariable Long id){
        Optional<CategoryProductEntity> optionalCategoryProduct = categoryProductService.obtenerCategoriaPorId(id);
        return optionalCategoryProduct
                .map(categoryProduct -> ResponseEntity.ok().body(categoryProduct))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<CategoryProductEntity> guardarCategoriaProducto(@RequestBody CategoryProductEntity categoryProductEntity){
        CategoryProductEntity savedCategoryProduct = categoryProductService.guardarCategoriaProducto(categoryProductEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryProduct);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarCategoriaProductoPorId(@PathVariable Long id) {

        categoryProductService.borrarCategoriaProductoPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<CategoryProductEntity> editarCategoriaProductoPorId(@PathVariable Long id, @RequestBody CategoryProductEntity categoryProductEdit){
        CategoryProductEntity editedCategoryProduct = categoryProductService.editarCategoriaProductoPorId(id, categoryProductEdit);
        if (editedCategoryProduct != null){
            return ResponseEntity.ok().body(editedCategoryProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
