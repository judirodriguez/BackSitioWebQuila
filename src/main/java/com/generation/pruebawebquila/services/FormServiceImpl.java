package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.FormEntity;
import com.generation.pruebawebquila.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;
    @Override
    public FormEntity guardarFormulario(FormEntity formEntity){
        return formRepository.save(formEntity);
    }

}
