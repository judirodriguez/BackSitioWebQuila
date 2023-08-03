package com.generation.pruebawebquila.repositories;

import com.generation.pruebawebquila.entities.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {

}

