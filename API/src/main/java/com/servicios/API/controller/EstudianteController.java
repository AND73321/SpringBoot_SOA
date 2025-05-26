package com.servicios.API.controller;

import com.servicios.API.entity.Estudiante;
import com.servicios.API.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> getAll(){
        return service.getAllEstudiantes();
    }

    @GetMapping("/{cedula}")
    public Optional<Estudiante> getById(@PathVariable("cedula") String cedula){
        return service.getEstudianteByCedula(cedula);
    }

    @PostMapping
    public void save(@RequestBody Estudiante estudiante){
        service.saveEstudiante(estudiante);
    }

    //FORMA 1 SIN MENSAJE
    /*@PutMapping("/{cedula}")
    public void update(@PathVariable String cedula, @RequestBody Estudiante estudiante){
        service.updateEstudiante(cedula, estudiante);
    }*/

    //FORMA 2 CON MENSAJE
    /*@PutMapping("/{cedula}")
    public ResponseEntity<Map<String, String>> update(@PathVariable String cedula, @RequestBody Estudiante estudiante){
        service.updateEstudiante(cedula, estudiante);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "Se Actualizo correctamente mi CHAVO");
        return ResponseEntity.ok(response);
    }*/

    //FORMA 3 CON MENSAJE y ESTADO
    @PutMapping("/{cedula}")
    public ResponseEntity<Map<String, String>> update(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
        Estudiante updated = service.updateEstudiante(cedula, estudiante);
        Map<String, String> response = new HashMap<>();
        if (updated != null) {
            response.put("message", "Estudiante actualizado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Estudiante no encontrado");
            return ResponseEntity.status(404).body(response);
        }
    }

    @DeleteMapping("/{cedula}")
    public boolean delete(@PathVariable("cedula") String cedula){
        return service.deleteEstudiante(cedula);
    }
}
