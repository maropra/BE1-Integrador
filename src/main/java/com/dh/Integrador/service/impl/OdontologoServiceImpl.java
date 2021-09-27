package com.dh.Integrador.service.impl;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.OdontologoDTO;
import com.dh.Integrador.model.Odontologo;
import com.dh.Integrador.repository.OdontologoRepository;
import com.dh.Integrador.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoServiceImpl implements OdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<OdontologoDTO> obtenerTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOSet = new HashSet<>();
        for (Odontologo odontologo : odontologos){
            odontologoDTOSet.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOSet;
    }

    @Override
    public OdontologoDTO obtener(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isEmpty()){
            throw new ResourceNotFoundException("El odontologo con id " + id + " no fue encontrado");
        }
        return mapper.convertValue(odontologo, OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO guardar(OdontologoDTO odontologoDto) throws BadRequestException {
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        if(odontologoDto.getNombre() == null || odontologoDto.getApellido() == null || odontologoDto.getMatricula() == null){
            throw new BadRequestException("El odontologo ingresado es nulo");
        }
        odontologoRepository.save(odontologo);
        return odontologoDto;
    }

    @Override
    public void elminar(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe el odontologo con id: "+id);
        }
    }

    @Override
    public OdontologoDTO modificar(OdontologoDTO nuevoOdontologoDto) throws ResourceNotFoundException {
        Odontologo odontologo = mapper.convertValue(nuevoOdontologoDto, Odontologo.class);
        if(odontologo == null){
            throw new ResourceNotFoundException("El paciente con id " + nuevoOdontologoDto.getId() + " que quiere modificar no fue encontrado");
        }
        odontologoRepository.save(odontologo);
        return nuevoOdontologoDto;
    }

}
