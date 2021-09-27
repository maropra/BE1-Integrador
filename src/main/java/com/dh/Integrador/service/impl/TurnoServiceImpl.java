package com.dh.Integrador.service.impl;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.OdontologoDTO;
import com.dh.Integrador.model.DTO.TurnoDTO;
import com.dh.Integrador.model.Odontologo;
import com.dh.Integrador.model.Paciente;
import com.dh.Integrador.model.Turno;
import com.dh.Integrador.repository.OdontologoRepository;
import com.dh.Integrador.repository.PacienteRepository;
import com.dh.Integrador.repository.TurnoRepository;
import com.dh.Integrador.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoServiceImpl implements TurnoService {
    @Autowired
    TurnoRepository turnoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<TurnoDTO> obtenerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOSet = new HashSet<>();
        for (Turno turno : turnos){
            turnoDTOSet.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOSet;
    }

    @Override
    public TurnoDTO obtener(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isEmpty()){
            throw new ResourceNotFoundException("El turno con id " + id + " no fue encontrado");
        }
        return mapper.convertValue(turno, TurnoDTO.class);
    }

    @Override
    public TurnoDTO guardar(TurnoDTO turnoDTO) throws BadRequestException {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        //Optional<Paciente> paciente = pacienteRepository.findById(turno.getPaciente().getId());
        //Optional<Odontologo> odontologo = odontologoRepository.findById(turno.getOdontologo().getId());
        //if(paciente.isPresent() || odontologo.isPresent()){
        //    throw new BadRequestException("El paciente o el odontologo no existen");
        //}
        turnoRepository.save(turno);
        return turnoDTO;
    }

    @Override
    public void elminar(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe el turno con id: " + id);
        }
    }

    @Override
    public TurnoDTO modificar(TurnoDTO nuevoTurnoDto) throws ResourceNotFoundException {
        Turno turno = mapper.convertValue(nuevoTurnoDto, Turno.class);
        if(turno == null){
            throw new ResourceNotFoundException("El turno con id " + nuevoTurnoDto.getId() + " que quiere modificar no fue encontrado");
        }
        turnoRepository.save(turno);
        return nuevoTurnoDto;
    }
}
