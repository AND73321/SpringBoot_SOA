package com.soaproject.estudiantes.controller;

import com.soaproject.estudiantes.entity.Estudiante;
import com.soaproject.estudiantes.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("estudiantes", service.get());
        return "index";
    }

    @GetMapping("/estudiantes/nuevo")
    public String formulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }

    @GetMapping("/estudiantes")
    public String buscarEstudiantes(@RequestParam(name = "cedula", required = false) String cedula, Model model) {
        if (cedula == null || cedula.trim().isEmpty()) {
            model.addAttribute("estudiantes", service.get());
        } else {
            Optional<Estudiante> estudiante = service.getById(cedula);
            if (estudiante.isPresent()) {
                model.addAttribute("estudiantes", List.of(estudiante.get()));
            } else {
                model.addAttribute("estudiantes", List.of());
                model.addAttribute("mensaje", "No se encontró el estudiante con cédula: " + cedula);
            }
        }
        return "index";
    }


    @PostMapping("/estudiantes")
    public String guardar(@ModelAttribute Estudiante estudiante) {
        service.post(estudiante);
        return "redirect:/";
    }

    @GetMapping("/estudiantes/editar/{cedula}")
    public String editar(@PathVariable String cedula, Model model) {
        Estudiante estudiante = service.getById(cedula).orElseThrow();
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    @GetMapping("/estudiantes/eliminar/{cedula}")
    public String eliminar(@PathVariable String cedula) {
        service.delete(cedula);
        return "redirect:/";
    }
}
