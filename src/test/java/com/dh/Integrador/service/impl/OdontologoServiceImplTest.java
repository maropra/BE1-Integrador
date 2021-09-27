package com.dh.Integrador.service.impl;

import com.dh.Integrador.model.DTO.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceImplTest {

    @Autowired
    OdontologoServiceImpl odontologoService;

    @Test
    public void testObtener(){
        try {
            OdontologoDTO odontologoDTO= new OdontologoDTO();
            odontologoDTO.setId(1L);
            odontologoDTO.setNombre("Jorge");
            odontologoDTO.setApellido("Lopez");
            odontologoDTO.setMatricula("1234");

            odontologoService.guardar(odontologoDTO);
            OdontologoDTO odontologoEncontrado = odontologoService.obtener(1L);

            assertEquals(odontologoDTO.getNombre(), odontologoEncontrado.getNombre());
            assertEquals(odontologoDTO.getApellido(), odontologoEncontrado.getApellido());
            assertEquals(odontologoDTO.getMatricula(), odontologoEncontrado.getMatricula());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testObtenerTodos(){
        try {
            OdontologoDTO odontologoDTO= new OdontologoDTO();
            odontologoDTO.setId(1L);
            odontologoDTO.setNombre("Jorge");
            odontologoDTO.setApellido("Lopez");
            odontologoDTO.setMatricula("1234");

            odontologoService.guardar(odontologoDTO);
            Set<OdontologoDTO> odontologos = odontologoService.obtenerTodos();

            boolean resultado = odontologos.size() > 0;
            assertTrue(resultado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}