package com.soaproject.estudiantes.service;

import com.soaproject.estudiantes.entity.Estudiante;
import com.soaproject.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> get() {
        return repository.findAll();
    }

    public Optional<Estudiante> getById(String cedula) {
        return repository.findById(cedula);
    }

    public Estudiante post(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public void delete(String cedula) {
        repository.deleteById(cedula);
    }
}
