package com.generation.pruebawebquila.repositories;

import com.generation.pruebawebquila.entities.ImageProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProductEntity, Long> {


}
