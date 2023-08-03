package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.ImageProductEntity;
import com.generation.pruebawebquila.repositories.ImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageProductServiceImpl implements ImageProductService{


    @Autowired
    ImageProductRepository imageProductRepository;
    @Override
    public List<ImageProductEntity> obtenerImagenProducto(){
        List<ImageProductEntity> listImagesProduct = imageProductRepository.findAll();
        return listImagesProduct;
    }
    @Override
    public Optional<ImageProductEntity> obtenerImagenProductoPorId(Long id) {
        return imageProductRepository.findById(id);
    }
    @Override
    public ImageProductEntity guardarImagenProducto(ImageProductEntity imageProductEntity){
        return imageProductRepository.save(imageProductEntity);
    }

    @Override
    public void borrarImagenProductoPorId(Long id) {
        Optional<ImageProductEntity> optionalImageProduct = imageProductRepository.findById(id);{
            if (optionalImageProduct.isPresent()){
                ImageProductEntity ImageProduct = optionalImageProduct.get();
                imageProductRepository.delete(ImageProduct);
                System.out.println("La Imagen se ha eliminado correctamente");
            }   else {
                System.out.println("No se encontro ninguna imagen con ese Id");
            }

        }
    }

    @Override
    public ImageProductEntity editarImagenProductoPorId(Long id, ImageProductEntity imageProductEdit) {
        Boolean existe = imageProductRepository.existsById(id);

        if (existe){ //preguntar si se edita el id de producto
            ImageProductEntity imagenProductoSeleccionado = imageProductRepository.findById(id).get();
            imagenProductoSeleccionado.setUrlImageProduct(imageProductEdit.getUrlImageProduct());
            return imageProductRepository.save(imagenProductoSeleccionado);
        }
        return null;
    }


}
