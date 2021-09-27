package com.dh.Integrador.service;

import com.dh.Integrador.model.Domicilio;
import com.dh.Integrador.model.Paciente;

import java.util.Optional;

public interface DomicilioService {
    public Optional<Domicilio> obtener(Long id);
    public String guardar(Domicilio domicilio);
    public String eliminar(Long id);
    public Domicilio modificar(Domicilio nuevoDomicilio);
}
