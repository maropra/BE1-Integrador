package com.dh.Integrador.service;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.TurnoDTO;
import com.dh.Integrador.model.Turno;

import java.util.Set;

public interface TurnoService {
    public Set<TurnoDTO> obtenerTodos();
    public TurnoDTO obtener(Long id) throws ResourceNotFoundException;
    public TurnoDTO guardar(TurnoDTO turnoDTO) throws BadRequestException;
    public void elminar(Long id) throws ResourceNotFoundException;
    public TurnoDTO modificar(TurnoDTO nuevoTurnoDto) throws ResourceNotFoundException;
}
