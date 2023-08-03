package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.ImageProductEntity;
import com.generation.pruebawebquila.services.ImageProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/imagenProducto")
public class ImageProductController {

    @Autowired
    private ImageProductServiceImpl imageProductService;

    @GetMapping("/listaImagen")
    public List<ImageProductEntity> obtenerImagenesProducto(){
        return imageProductService.obtenerImagenProducto();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ImageProductEntity> obtenerImagenProductoPorId(@PathVariable Long id){
        Optional<ImageProductEntity> optionalImageProduct = imageProductService.obtenerImagenProductoPorId(id);
        return optionalImageProduct
                .map(imageProduct -> ResponseEntity.ok().body(imageProduct))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<ImageProductEntity> guardarImagenProducto(@RequestBody ImageProductEntity imageProductEntity){
        ImageProductEntity savedImageProduct = imageProductService.guardarImagenProducto(imageProductEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedImageProduct);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarImagenProductoPorId(@PathVariable Long id) {

        imageProductService.borrarImagenProductoPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ImageProductEntity> editarImagenProductoPorId(@PathVariable Long id, @RequestBody ImageProductEntity imageProductEdit){
        ImageProductEntity editedImageProduct = imageProductService.editarImagenProductoPorId(id, imageProductEdit);
        if (editedImageProduct != null){
            return ResponseEntity.ok().body(editedImageProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
