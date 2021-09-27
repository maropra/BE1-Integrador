package com.dh.Integrador.service.impl;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.PacienteDTO;
import com.dh.Integrador.model.Paciente;
import com.dh.Integrador.repository.PacienteRepository;
import com.dh.Integrador.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<PacienteDTO> obtenerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOSet = new HashSet<>();
        for (Paciente paciente : pacientes){
            pacienteDTOSet.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOSet;
    }

    @Override
    public PacienteDTO obtener(Long id) throws ResourceNotFoundException{
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()){
            throw new ResourceNotFoundException("El odontologo con id " + id + " no fue encontrado");
        }
        return mapper.convertValue(paciente, PacienteDTO.class);

    }

    @Override
    public PacienteDTO guardar(PacienteDTO pacienteDTO) throws BadRequestException {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        if(pacienteDTO.getNombre() == null || pacienteDTO.getApellido() == null || pacienteDTO.getDni() == null){
            throw new BadRequestException("El odontologo ingresado es nulo");
        }
        pacienteRepository.save(paciente);
        return pacienteDTO;
    }

    @Override
    public void elminar(Long id) throws ResourceNotFoundException {
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe el paciente con id: " + id);
        }
    }

    @Override
    public PacienteDTO modificar(PacienteDTO nuevoPacienteDTO) throws ResourceNotFoundException{
        Paciente paciente = mapper.convertValue(nuevoPacienteDTO, Paciente.class);
        if(paciente == null){
            throw new ResourceNotFoundException("El paciente con id " + nuevoPacienteDTO.getId() + " que quiere modificar no fue encontrado");
        }
        pacienteRepository.save(paciente);
        return nuevoPacienteDTO;
    }

}
