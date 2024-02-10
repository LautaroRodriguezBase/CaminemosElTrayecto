package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.Sancionable;
import java.util.ArrayList;

public class Alumno extends User implements Sancionable {

    private String nombre;

    private String apellido;

    private String dni;

    private int numTelefono;

    private ArrayList<Curso> cursosAprobados;

    private ArrayList<Curso> cursosInscriptos;

    public Alumno(String nombre, String apellido, String dni, int numTelefono, ArrayList<Curso> cursosAprobados, ArrayList<Curso> cursosInscriptos, String uName, String uPass) {
        super(uName, uPass);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numTelefono = numTelefono;
        this.cursosAprobados = cursosAprobados;
        this.cursosInscriptos = cursosInscriptos;
    }
    
    //Abstractas
    public void sancionar() {
    }
    public void quitarSancion() {
    }
    public void mostrarVentana() {
    }
    
    //DD
    public boolean esAdmin(User u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean esDocente(User u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
