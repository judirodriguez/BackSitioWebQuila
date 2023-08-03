package com.generation.pruebawebquila.repositories;

import com.generation.pruebawebquila.entities.EntrepreneurEntity;
import com.generation.pruebawebquila.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepreneurRepository extends JpaRepository<EntrepreneurEntity, Long> {



}
