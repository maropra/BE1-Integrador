package com.dh.Integrador.service;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.PacienteDTO;

import java.util.Set;

public interface PacienteService {
    public Set<PacienteDTO> obtenerTodos();
    public PacienteDTO obtener(Long id) throws ResourceNotFoundException;
    public PacienteDTO guardar(PacienteDTO pacienteDto) throws BadRequestException;
    public void elminar(Long id) throws ResourceNotFoundException;
    public PacienteDTO modificar(PacienteDTO nuevoPacienteDto) throws ResourceNotFoundException;
}
