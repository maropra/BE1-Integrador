package com.dh.Integrador.model.DTO;

import com.dh.Integrador.model.Domicilio;
import com.dh.Integrador.model.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaAlta;

}