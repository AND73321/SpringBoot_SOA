package com.servicios.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="estudiantes")
public class Estudiante {

    @Id
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)  --- Esta linea se utiliza para la creacion de un ID autoincrementable de tipo (INT, BIGINT)
    private String cedula;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
