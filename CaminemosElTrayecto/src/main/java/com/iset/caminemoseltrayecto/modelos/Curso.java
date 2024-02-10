package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.Docente;
import java.util.ArrayList;

public class Curso {

    private static final int cantAlumnosMax = 15;
    
    private String nombre;
    private String descripcion;
    private String estado;

    private ArrayList<Alumno> alumnos;
    private Docente titular;
    private Curso[] cursosPrevios;

    public Curso(String nombre, String descripcion, String estado, ArrayList alumnos, Docente titular, Curso[] cursosPrevios, int cantAlumnosMax) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.alumnos = alumnos;
        this.titular = titular;
        this.cursosPrevios = cursosPrevios;
    }

    public Alumno addAlumno(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String cambiarEstado(String estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
