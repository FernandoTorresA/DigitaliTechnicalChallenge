package com.digitali.digitalitechnicalchallenge.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    //puede que no tenga segundo nombre
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    //puede que no tenga segundo apellido
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "direccion", nullable = false)
    private String direccion;
}
