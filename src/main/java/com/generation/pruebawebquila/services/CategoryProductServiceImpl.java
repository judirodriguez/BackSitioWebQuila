package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.CategoryProductEntity;
import com.generation.pruebawebquila.repositories.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductServiceImpl implements CategoryProductService{

    @Autowired
    CategoryProductRepository categoryProductRepository;
    @Override
    public List<CategoryProductEntity> obtenerCategoriasProducto(){
        List<CategoryProductEntity> listCategories = categoryProductRepository.findAll();
        return listCategories;
    }
    @Override
    public Optional<CategoryProductEntity> obtenerCategoriaPorId(Long id) {
        return categoryProductRepository.findById(id);
    }
    @Override
    public CategoryProductEntity guardarCategoriaProducto(CategoryProductEntity categoryProductEntity){
        return categoryProductRepository.save(categoryProductEntity);
    }

    @Override
    public void borrarCategoriaProductoPorId(Long id) {
        Optional<CategoryProductEntity> optionalCategoryProduct = categoryProductRepository.findById(id);{
            if (optionalCategoryProduct.isPresent()){
                CategoryProductEntity Category = optionalCategoryProduct.get();
                categoryProductRepository.delete(Category);
                System.out.println("La categoria se ha eliminado correctamente");
            }   else {
                System.out.println("No se encontro ninguna categoria con ese Id");
            }

        }
    }

    @Override
    public CategoryProductEntity editarCategoriaProductoPorId(Long id, CategoryProductEntity categoryProductEdit) {
        Boolean existe = categoryProductRepository.existsById(id);

        if (existe){
            CategoryProductEntity categoriaSeleccionada = categoryProductRepository.findById(id).get();
            categoriaSeleccionada.setNameCategory(categoryProductEdit.getNameCategory());
            categoriaSeleccionada.setUrlImageCategory(categoryProductEdit.getUrlImageCategory());
            return categoryProductRepository.save(categoriaSeleccionada);
        }
        return null;
    }

}
