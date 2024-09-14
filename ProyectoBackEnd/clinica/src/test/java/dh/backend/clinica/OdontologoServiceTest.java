package dh.backend.clinica;

import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.exception.CustomerAlreadyExistsException;
import dh.backend.clinica.service.impl.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional

class OdontologoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(OdontologoServiceTest.class);
    @Autowired
    OdontologoService odontologoService;
    Odontologo odontologo;
    Odontologo odontologoDesdeDb;

    @BeforeEach
    void cargarDatos() throws CustomerAlreadyExistsException {
        odontologo = new Odontologo();
        odontologo.setApellido("Torres");
        odontologo.setNombre("Jose");
        odontologo.setNroMatricula("1010LO");
        odontologoDesdeDb = odontologoService.guardarOdontologo(odontologo);

    }
    @Test
    @DisplayName("Testear que un odontologo pueda acceder por id")
    void
    caso1(){
        //Dado
        Integer id = odontologoDesdeDb.getId();
        //cuando
        Odontologo odontologoRecuperado = odontologoService.buscarPorId(id).get();
        // entonces
        assertEquals(id, odontologoRecuperado.getId());
    }

    @Test
    @DisplayName("Listar todos los pacientes")
    void caso2(){
        //Dado
        List<Odontologo> odontologos;
        // cuando
        odontologos = odontologoService.buscarTodos();
        // entonces
        assertFalse(odontologos.isEmpty());
    }
}