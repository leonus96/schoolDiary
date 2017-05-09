package com.leonus96.joseph.siscolegio.Models;

/**
 * Created by joseph on 02/05/17.
 */

public class Alumno {
    private String dni;
    private String nombres;
    private String apellidos;
    private Calificaciones calif;

    public Alumno(String dni, String nombres, String apellidos, Calificaciones calif) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.calif = calif;
    }
}
