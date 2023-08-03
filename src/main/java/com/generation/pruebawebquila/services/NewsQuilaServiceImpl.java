package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.NewsQuilaEntity;
import com.generation.pruebawebquila.repositories.NewsQuilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsQuilaServiceImpl implements NewsQuilaService {

    @Autowired
    NewsQuilaRepository newsQuilaRepository;
    @Override
    public NewsQuilaEntity guardarNoticia(NewsQuilaEntity newsQuilaEntity){
        return newsQuilaRepository.save(newsQuilaEntity);
    }

}
