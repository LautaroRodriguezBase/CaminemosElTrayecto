package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.Reseteable;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import com.iset.caminemoseltrayecto.visual.AlumnoFrame;

import java.util.ArrayList;

public class Alumno extends User implements Sancionable, Reseteable{//era necesaria una clase intermedia para alumno y docente

    private String nombre, apellido, dni, numTelefono;

    private int estado = 0;//Podria ser varios ademas de sancionado, como "en revision", "en mantenimiento", etc

    private ArrayList<Curso> cursosAprobados;
    private ArrayList<Curso> cursosInscriptos;

    public Alumno(String uName, String uPass, String nombre, String apellido, String dni, String numTelefono) {
        super(uName, uPass);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public int getEstado() {
        return estado;
    }

    public ArrayList<Curso> getCursosAprobados() {
        return cursosAprobados;
    }

    public ArrayList<Curso> getCursosInscriptos() {
        return cursosInscriptos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    //Sancionable
    public void sancionar() {
        this.estado = 1;
    }
    public void quitarSancion() {
        this.estado = 0;
    }

    //DD Heredadas
    @Override
    public void mostrarVentana() {
        new AlumnoFrame(this).setVisible(true);
    }
    @Override
    public boolean esAdmin(User u) {
        return false;
    }
    @Override
    public boolean esDocente(User u) {
        return false;
    }
    
    //Reseteable
    @Override
    public void resetPassword() {
        super.setUserPass(this.dni);
    }
}
