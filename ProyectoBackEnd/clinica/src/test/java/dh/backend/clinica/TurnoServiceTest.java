package dh.backend.clinica;

import dh.backend.clinica.dto.request.TurnoRequestDto;
import dh.backend.clinica.dto.response.TurnoResponseDto;
import dh.backend.clinica.entity.Domicilio;
import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.entity.Turno;
import dh.backend.clinica.service.impl.OdontologoService;
import dh.backend.clinica.service.impl.PacienteService;
import dh.backend.clinica.service.impl.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class TurnoServiceTest {
    /*static final Logger logger = LoggerFactory.getLogger(TurnoServiceTest.class);
    @Autowired
    TurnoService turnoService;
    Turno turno;
    TurnoResponseDto turnoDesdeDb;
    Paciente paciente;
    PacienteService pacienteService;
    Paciente pacienteDesdeDB;
    Odontologo odontologo;
    OdontologoService odontologoService;
    Odontologo odontologoDesdeDb;

    @BeforeEach
    void cargarDatos(){
        Domicilio domicilio = new Domicilio(null, "Falsa",145,"CABA","Buenos Aires");
        paciente = new Paciente();
        paciente.setApellido("Castro");
        paciente.setNombre("Maria");
        paciente.setDni("48974646");
        paciente.setFechaIngreso(LocalDate.of(2024,7,15));
        paciente.setDomicilio(domicilio);
        pacienteDesdeDB = pacienteService.guardarPaciente(paciente);

        odontologo = new Odontologo();
        odontologo.setApellido("Torres");
        odontologo.setNombre("Jose");
        odontologo.setNroMatricula("1010LO");
        odontologoDesdeDb = odontologoService.guardarOdontologo(odontologo);

        turno.setFecha(LocalDate.of(2024,8,30));
        turnoDesdeDb= turnoService.guardarTurno(new TurnoRequestDto()));
    }

    }*/

}