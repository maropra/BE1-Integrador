package com.dh.Integrador.controller;


import com.dh.Integrador.exceptions.BadRequestException;
import com.dh.Integrador.exceptions.ResourceNotFoundException;
import com.dh.Integrador.model.DTO.TurnoDTO;
import com.dh.Integrador.model.Turno;
import com.dh.Integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @GetMapping("/turnos")
    public Set<TurnoDTO> listarTurnos(){
        return turnoService.obtenerTodos();
    }

    @GetMapping("/turnos/{id}")
    public ResponseEntity<TurnoDTO> mostrarTurnoPorId (@PathVariable Long id) throws ResourceNotFoundException {
        TurnoDTO turno = turnoService.obtener(id);
        return ResponseEntity.ok(turno);
    }

    @PostMapping("/turnos")
    public ResponseEntity<TurnoDTO> agegarTurno (@RequestBody TurnoDTO turno) throws BadRequestException {
        turnoService.guardar(turno);
        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/turnos/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.elminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @PutMapping("/turnos")
    public ResponseEntity<TurnoDTO> modificarTurno(@RequestBody TurnoDTO turno) throws ResourceNotFoundException {
        turnoService.modificar(turno);
        return ResponseEntity.ok(turno);
    }
}
