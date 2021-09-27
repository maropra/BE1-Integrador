package com.dh.Integrador.model.DTO;

import com.dh.Integrador.model.Odontologo;
import com.dh.Integrador.model.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha;
    private Odontologo odontologo;
    private Paciente paciente;
}
