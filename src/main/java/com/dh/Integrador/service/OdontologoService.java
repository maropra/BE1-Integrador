package com.dh.Integrador.service;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.OdontologoDTO;
import java.util.Collection;
import java.util.Set;

public interface OdontologoService {

    public Set<OdontologoDTO> obtenerTodos();
    public OdontologoDTO obtener(Long id) throws ResourceNotFoundException;
    public OdontologoDTO guardar(OdontologoDTO odontologoDto) throws BadRequestException;
    public void elminar(Long id) throws ResourceNotFoundException;
    public OdontologoDTO modificar(OdontologoDTO nuevoOdontologo) throws ResourceNotFoundException;
}
