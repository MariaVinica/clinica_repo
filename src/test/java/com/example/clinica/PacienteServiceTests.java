package com.example.clinica;

import com.example.clinica.model.Domicilio;
import com.example.clinica.model.Paciente;
import com.example.clinica.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTests {

    @Autowired
    private PacienteService pacienteService;


    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Bucarelli", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Caramela", "Aldana", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("La Pampa", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Ginebra", "Garzon", "99999999", new Date(), domicilio1));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Tomas Lebreton", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Bonnie", "Canela", "12345678", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }


}
