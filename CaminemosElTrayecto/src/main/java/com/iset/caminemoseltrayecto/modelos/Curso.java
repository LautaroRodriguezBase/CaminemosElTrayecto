package com.iset.caminemoseltrayecto.modelos;

import java.util.ArrayList;

public class Curso {

    public static final int cantAlumnosMax = 15;
    private static final String [] estadosCurso = {"Propuesto", "Habilitado", "Cerrado", "Finalizado"};

    private String nombre;
    private String descripcion;
    private String estadoCurso = "Propuesto";

    private ArrayList<Alumno> alumnos;
    private Docente titular;
    private Curso[] cursosPrevios;

    public Curso(String nombre, String descripcion, String estado, Docente titular, Curso[] cursosPrevios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoCurso = estado;
        this.titular = titular;
        this.cursosPrevios = cursosPrevios;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getEstadoCurso() {
        return estadoCurso;
    }
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    public Docente getTitular() {
        return titular;
    }
    public Curso[] getCursosPrevios() {
        return cursosPrevios;
    }
    public void addAlumno(Alumno a) {
        alumnos.add(a);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }
    public void setTitular(Docente titular) {
        this.titular = titular;
    }

    public void cambiarEstado(String estado) {
        for(String estadosCurso1 : Curso.estadosCurso) {
            if (estadosCurso1.equals(estado)) {
                this.estadoCurso = estado;
            }
        }
    }

    // Funciones estaticas
    public static String[] getEstadosCurso(){
        return Curso.estadosCurso;
    }
}
