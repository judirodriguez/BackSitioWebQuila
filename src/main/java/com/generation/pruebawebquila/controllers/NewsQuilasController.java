package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.NewsQuilaEntity;
import com.generation.pruebawebquila.services.NewsQuilaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/Noticia")

public class NewsQuilasController {

    @Autowired
    private NewsQuilaServiceImpl newsQuilaService;

    @PostMapping("/guardar")
    public ResponseEntity<NewsQuilaEntity> guardarNoticia(@RequestBody NewsQuilaEntity newsQuilaEntity){
        NewsQuilaEntity savedNews = newsQuilaService.guardarNoticia(newsQuilaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNews);
    }

}
