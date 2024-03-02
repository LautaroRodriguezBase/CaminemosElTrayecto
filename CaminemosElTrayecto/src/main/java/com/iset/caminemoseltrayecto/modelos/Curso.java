package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.Docente;
import java.util.ArrayList;

public class Curso {

    private static final int cantAlumnosMax = 15;
    
    private String nombre;
    private String descripcion;
    private int estadoCurso = 0;

    private ArrayList<Alumno> alumnos;
    private Docente titular;
    private Curso[] cursosPrevios;

    public Curso(String nombre, String descripcion, int estado, ArrayList alumnos, Docente titular, Curso[] cursosPrevios, int cantAlumnosMax) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoCurso = estado;
        this.alumnos = alumnos;
        this.titular = titular;
        this.cursosPrevios = cursosPrevios;
    }

    public void addAlumno(Alumno a) {
        alumnos.add(a);
    }

    public void cambiarEstado(int estado) {
        if(estado >= 0 && estado < 4){
            estadoCurso = estado;
        }
    }
}
