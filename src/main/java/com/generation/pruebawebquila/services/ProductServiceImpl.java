package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.ProductEntity;
import com.generation.pruebawebquila.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductEntity> obtenerProductos(){
        List<ProductEntity> listProducts = productRepository.findAll(); //listaProductos
        return listProducts;
    }
    @Override
    public Optional<ProductEntity> obtenerProductoPorId(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public ProductEntity guardarProducto(ProductEntity productEntity){ //productoNuevo
        return productRepository.save(productEntity);
    }

    @Override
    public void borrarProductoPorId(Long id) {
            Optional<ProductEntity> optionalProduct = productRepository.findById(id);{
                if (optionalProduct.isPresent()){
                    ProductEntity product = optionalProduct.get();
                    productRepository.delete(product);
                    System.out.println("El producto se elimino correctamente");
                }   else {
                        System.out.println("No se encontro ningún producto con ese Id");
                }

            }
    }

    @Override
    public ProductEntity editarProductoPorId(Long id, ProductEntity productEdit) {
        Boolean existe = productRepository.existsById(id);

        if (existe){
            ProductEntity productoSeleccionado = productRepository.findById(id).get();
            productoSeleccionado.setName_product(productEdit.getName_product());
            productoSeleccionado.setDescription_product(productEdit.getDescription_product());
            productoSeleccionado.setCategory(productEdit.getCategory()); //damos la posibilidad de editar - VER SI HAY QUE MANTENER ESTA LÍNEA O NO-
            productoSeleccionado.setEntrepreneur(productEdit.getEntrepreneur());
            return productRepository.save(productoSeleccionado);
        }
        return null;
    }

}
