package dh.backend.clinica.service;

import dh.backend.clinica.entity.Odontologo;


import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);

    Optional<Odontologo> buscarPorId(Integer id);
    List<Odontologo> buscarTodos();

    void modificarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Integer id);
    Optional<Odontologo> buscarPorMatricula(String nroMatricula);
}
