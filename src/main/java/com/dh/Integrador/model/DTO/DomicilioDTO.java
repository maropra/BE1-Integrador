package com.dh.Integrador.model.DTO;

import com.dh.Integrador.model.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private Long id;
    private String calle;
    private String numero;
    private String ciudad;
    private String pais;
}
