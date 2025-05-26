package com.servicios.API.service;

import com.servicios.API.entity.Estudiante;
import com.servicios.API.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository repository;

    public List<Estudiante> getAllEstudiantes() {
        return repository.findAll();
    }

    public Optional<Estudiante> getEstudianteByCedula(String cedula) {
        return repository.findById(cedula);
    }

    public Estudiante saveEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante updateEstudiante(String cedula, Estudiante estudiante) {
        if (repository.existsById(cedula)) {
            estudiante.setCedula(cedula);
            return repository.save(estudiante);
        }
        return null;
    }

    public boolean deleteEstudiante(String cedula) {
        if (repository.existsById(cedula)) {
            repository.deleteById(cedula);
            return true;
        }
        return false;
    }
}






