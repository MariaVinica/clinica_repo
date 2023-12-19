package com.example.clinica;

import com.example.clinica.model.Domicilio;
import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.model.Turno;
import com.example.clinica.service.OdontologoService;
import com.example.clinica.service.PacienteService;
import com.example.clinica.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest

public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Bucarelli", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Ginebra", "Aldana", "88888888", new Date(), domicilio));
        this.odontologoService.registrarOdontologo(new Odontologo("Camila", "Aldana", 0001));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        turnoService.registrarTurno(new Turno(pacienteService.buscar(1).get(),odontologoService.buscar(1).get(),new Date()));
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void eliminarTurnoTest(){
        turnoService.eliminar(1);
        Assert.assertFalse(turnoService.buscar(1).isPresent());
    }
}
