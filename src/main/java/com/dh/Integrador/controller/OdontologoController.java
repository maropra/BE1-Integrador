package com.dh.Integrador.controller;

import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.OdontologoDTO;
import com.dh.Integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @GetMapping("/odontologos")
    public ResponseEntity<Set<OdontologoDTO>> listarOdontologos() {
        Set<OdontologoDTO> listaOdontologos = odontologoService.obtenerTodos();
        return ResponseEntity.ok(listaOdontologos);
    }

    @GetMapping("/odontologos/{id}")
    public ResponseEntity<OdontologoDTO> mostrarOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        OdontologoDTO odontologo = odontologoService.obtener(id);
        return ResponseEntity.ok(odontologo);
    }

    @PostMapping("/odontologos")
    public ResponseEntity<OdontologoDTO> agregarOdontologo(@RequestBody OdontologoDTO odontologo) throws BadRequestException {
        odontologoService.guardar(odontologo);
        return ResponseEntity.ok(odontologo);
    }

    @DeleteMapping("/odontologos/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.elminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @PutMapping("/odontologos")
    public ResponseEntity<OdontologoDTO> modificarOdontologo(@RequestBody OdontologoDTO odontologo) throws ResourceNotFoundException {
        odontologoService.modificar(odontologo);
        return ResponseEntity.ok(odontologo);
    }

}
