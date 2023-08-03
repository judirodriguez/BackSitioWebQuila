package com.generation.pruebawebquila.controllers;

import com.generation.pruebawebquila.entities.EntrepreneurEntity;
import com.generation.pruebawebquila.services.EntrepreneurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/emprendedor")

public class EntrepreneurController {

    @Autowired
    private EntrepreneurServiceImpl entrepreneurService;

    @GetMapping("/listaEmprendedores")
    public List<EntrepreneurEntity> obtenerEmprendedores(){

        return entrepreneurService.obtenerEmprendedores();
    }

    @GetMapping("obtener/{id}")
    public ResponseEntity<EntrepreneurEntity> obtenerEmprendedorPorId(@PathVariable Long id){
        Optional<EntrepreneurEntity> optionalEntrepreneur = entrepreneurService.obtenerEmprendedorPorId(id);
        return optionalEntrepreneur
                .map(entrepreneur -> ResponseEntity.ok().body(entrepreneur))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<EntrepreneurEntity> guardarEmprendedor(@RequestBody EntrepreneurEntity entrepreneurEntity){
        EntrepreneurEntity savedEntrepreneur = entrepreneurService.guardarEmprendedor(entrepreneurEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntrepreneur);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarEmprendedorPorId(@PathVariable Long id) {

        entrepreneurService.borrarEmprendedorPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EntrepreneurEntity> editarEmprendedorPorId(@PathVariable Long id, @RequestBody EntrepreneurEntity entrepreneurEdit){
        EntrepreneurEntity editedEntrepreneur = entrepreneurService.editarEmprendedorPorId(id, entrepreneurEdit);
        if (editedEntrepreneur != null){
            return ResponseEntity.ok().body(editedEntrepreneur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
