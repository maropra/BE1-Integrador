package com.dh.Integrador.service.impl;

import com.dh.Integrador.model.Domicilio;
import com.dh.Integrador.model.Odontologo;
import com.dh.Integrador.model.Paciente;
import com.dh.Integrador.repository.DomicilioRepository;
import com.dh.Integrador.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;

    @Override
    public Optional<Domicilio> obtener(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public String guardar(Domicilio paciente) {
        if(paciente != null){
            domicilioRepository.save(paciente);
            return "Se guardó correctamente el domicilio";
        }
        return "No se pudo guardar el domicilio";
    }

    @Override
    public String eliminar(Long id) {
        if(domicilioRepository.findById(id).isPresent()){
            domicilioRepository.deleteById(id);
            return "Se ha eliminado el paciente";
        }
        return "No existe ese paciente";
    }

    @Override
    public Domicilio modificar(Domicilio nuevoDomicilio) {
        Optional<Domicilio> dom = obtener(nuevoDomicilio.getId());
        if(dom.isPresent()){
            dom.get().setCalle(nuevoDomicilio.getCalle());
            dom.get().setNumero(nuevoDomicilio.getNumero());
            dom.get().setCiudad(nuevoDomicilio.getCiudad());
            dom.get().setPais(nuevoDomicilio.getPais());
            return domicilioRepository.save(dom.get());
        }
        return null;
    }
}
