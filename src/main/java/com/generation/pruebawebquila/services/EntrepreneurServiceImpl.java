package com.generation.pruebawebquila.services;

import com.generation.pruebawebquila.entities.EntrepreneurEntity;
import com.generation.pruebawebquila.repositories.EntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepreneurServiceImpl implements EntrepreneurService{

    @Autowired
    EntrepreneurRepository entrepreneurRepository;
    @Override
    public List<EntrepreneurEntity> obtenerEmprendedores(){
        List<EntrepreneurEntity> listEntrepreneur = entrepreneurRepository.findAll();
        return listEntrepreneur;
    }
    @Override
    public Optional<EntrepreneurEntity> obtenerEmprendedorPorId(Long id) {
        return entrepreneurRepository.findById(id);
    }
    @Override
    public EntrepreneurEntity guardarEmprendedor(EntrepreneurEntity entrepreneurEntity){
        return entrepreneurRepository.save(entrepreneurEntity);
    }

    @Override
    public void borrarEmprendedorPorId(Long id) {
        Optional<EntrepreneurEntity> optionalEntrepreneur = entrepreneurRepository.findById(id);{
            if (optionalEntrepreneur.isPresent()){
                EntrepreneurEntity Entrepreneur = optionalEntrepreneur.get();
                entrepreneurRepository.delete(Entrepreneur);
                System.out.println("El emprendedor se ha eliminado correctamente");
            }   else {
                System.out.println("No se encontro ningún emprendedor con ese Id");
            }

        }
    }

    @Override
    public EntrepreneurEntity editarEmprendedorPorId(Long id, EntrepreneurEntity entrepreneurEdit) {
        Boolean existe = entrepreneurRepository.existsById(id);

        if (existe){ //preguntar si se edita el id de producto
            EntrepreneurEntity emprendedorSeleccionado = entrepreneurRepository.findById(id).get();
            emprendedorSeleccionado.setNameEntrepreneur(entrepreneurEdit.getNameEntrepreneur());
            emprendedorSeleccionado.setNameEntrepreneurship(entrepreneurEdit.getNameEntrepreneurship());
            emprendedorSeleccionado.setHistoryEntrepreneur(entrepreneurEdit.getHistoryEntrepreneur());
            emprendedorSeleccionado.setUrlImageEntrepreneur(entrepreneurEdit.getUrlImageEntrepreneur());
            return entrepreneurRepository.save(emprendedorSeleccionado);
        }
        return null;
    }

}
