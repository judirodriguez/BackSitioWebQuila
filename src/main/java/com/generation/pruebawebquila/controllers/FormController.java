package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.FormEntity;
import com.generation.pruebawebquila.entities.ImageProductEntity;
import com.generation.pruebawebquila.services.FormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/formulario")

public class FormController {

    @Autowired
    private FormServiceImpl formService;

    @PostMapping("/guardar")
    public ResponseEntity<FormEntity> guardarFormulario(@RequestBody FormEntity formEntity){
        FormEntity savedFormContact = formService.guardarFormulario(formEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFormContact);
    }

}
