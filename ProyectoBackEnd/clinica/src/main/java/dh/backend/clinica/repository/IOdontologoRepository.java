package dh.backend.clinica.repository;

import dh.backend.clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
    @Query("SELECT o FROM Odontologo o where o.nroMatricula = ?1")
    Optional<Odontologo> buscarMatricula(String nroMatricula);
}
