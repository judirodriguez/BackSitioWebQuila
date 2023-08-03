package com.generation.pruebawebquila.repositories;


import com.generation.pruebawebquila.entities.CategoryProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryProductRepository extends JpaRepository<CategoryProductEntity, Long> {

}
