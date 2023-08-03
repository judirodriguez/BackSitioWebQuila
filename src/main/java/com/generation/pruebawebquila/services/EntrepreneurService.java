package com.generation.pruebawebquila.services;


import com.generation.pruebawebquila.entities.EntrepreneurEntity;

import java.util.List;
import java.util.Optional;

public interface EntrepreneurService {

    List<EntrepreneurEntity> obtenerEmprendedores();
    Optional<EntrepreneurEntity> obtenerEmprendedorPorId(Long id);
    EntrepreneurEntity guardarEmprendedor(EntrepreneurEntity entrepreneurEntity);
    void borrarEmprendedorPorId(Long id);
    EntrepreneurEntity editarEmprendedorPorId(Long id, EntrepreneurEntity entrepreneurEntity);


}
