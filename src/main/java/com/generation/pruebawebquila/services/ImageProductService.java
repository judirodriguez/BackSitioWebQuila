package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.ImageProductEntity;

import java.util.List;
import java.util.Optional;

public interface ImageProductService {
    List<ImageProductEntity> obtenerImagenProducto();
    Optional<ImageProductEntity> obtenerImagenProductoPorId(Long id);
    ImageProductEntity guardarImagenProducto(ImageProductEntity imageProductEntity);
    void borrarImagenProductoPorId(Long id);
    ImageProductEntity editarImagenProductoPorId(Long id, ImageProductEntity imageProductEntity);

}
