package com.generation.pruebawebquila.repositories;

import com.generation.pruebawebquila.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //abajo estamos heredando los métodos de JpaRepository para trabajar los datos de ProductEntity
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
