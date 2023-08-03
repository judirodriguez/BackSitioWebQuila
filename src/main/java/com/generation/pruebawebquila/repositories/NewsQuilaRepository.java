package com.generation.pruebawebquila.repositories;

import com.generation.pruebawebquila.entities.NewsQuilaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsQuilaRepository extends JpaRepository<NewsQuilaEntity, Long> {

}
