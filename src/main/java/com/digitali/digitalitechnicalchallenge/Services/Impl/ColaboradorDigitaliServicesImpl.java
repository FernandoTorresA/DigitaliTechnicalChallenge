package com.digitali.digitalitechnicalchallenge.Services.Impl;

import com.digitali.digitalitechnicalchallenge.Entities.Colaborador;
import com.digitali.digitalitechnicalchallenge.Repositories.ColaboradorRepository;
import com.digitali.digitalitechnicalchallenge.Services.ColaboradorDigitaliServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorDigitaliServicesImpl implements ColaboradorDigitaliServices {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Override
    public List<Colaborador> getAll() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador getByRut(String rut) {
        return colaboradorRepository.getByRut(rut);
    }

    @Override
    public Colaborador createColaborador(Colaborador colaborador) {
        colaboradorRepository.save(colaborador);
        return colaborador;
    }

    @Override
    public Colaborador updateColaborador(String rut, Colaborador newColaboradorValues) {
        Colaborador colaborador = colaboradorRepository.getByRut(rut);
        if(colaborador != null){
            colaborador.setDireccion(newColaboradorValues.getDireccion());
            //actualizar más campos aquí...
            //...
            colaboradorRepository.save(colaborador);
            return colaborador;
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteColaborador(String rut) {
        Colaborador colaborador = colaboradorRepository.getByRut(rut);
        if(colaborador != null){
            colaboradorRepository.delete(colaborador);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getFechaNacimientoByRut(String rut) {
        Colaborador colaborador = colaboradorRepository.getByRut(rut);
        return colaborador != null ? colaborador.getFechaNacimiento().toString() : "No encontrado...";
    }
}
