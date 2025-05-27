package com.soaproject.estudiantes.repository;


import com.soaproject.estudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String>{
}
