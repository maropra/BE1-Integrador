package com.dh.Integrador.controller;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.PacienteDTO;
import com.dh.Integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/pacientes")
    public Set<PacienteDTO> listarPacientes(){
        return pacienteService.obtenerTodos();
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> mostrarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        PacienteDTO paciente = pacienteService.obtener(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("/pacientes")
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO paciente) throws BadRequestException {
        pacienteService.guardar(paciente);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
       pacienteService.elminar(id);
       return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @PutMapping("/pacientes")
    public ResponseEntity<PacienteDTO> modificarPaciente(@RequestBody PacienteDTO paciente) throws ResourceNotFoundException {
         pacienteService.modificar(paciente);
         return ResponseEntity.ok(paciente);
    }

}
