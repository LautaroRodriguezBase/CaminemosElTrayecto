package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.Reseteable;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import com.iset.caminemoseltrayecto.visual.DocenteFrame;

import java.util.ArrayList;

public class Docente extends User implements Sancionable, Reseteable{

    private String nombre, apellido, dni, numTelefono = "";
    
    private int estado = 0;//Podria ser varios ademas de sancionado, como "en revision", "en mantenimiento", etc
    
    private ArrayList<Curso> cursosCreados;

    public Docente(String uName, String uPass, String nombre, String apellido, String dni) {
        super(uName, uPass);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public ArrayList<Curso> getCursosCreados() {
        return cursosCreados;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getEstado() {//No tiene setter dado que lo definirian las infaces
        return estado;
    }

    public void addCurso(Curso curso) {
        cursosCreados.add(curso);
    }
    
    //Sancionable
    @Override
    public void sancionar() {
        this.estado = 1;
    }
    @Override
    public void quitarSancion() {
        this.estado = 0;
    }    
    
    
    //DD Heredado de User
    @Override
    public void mostrarVentana(){
        new DocenteFrame(this).setVisible(true);
    }
    @Override
    public boolean esAdmin(User u) {
        return false;
    }
    @Override
    public boolean esDocente(User u) {
        //if(u.getClass().getName().equals("Docente")){//Probar si devuelve la Clase de acceso o la del constructor
        return true;
    }
    
    //Reseteable
    @Override
    public void resetPassword() {
        super.setUserPass(this.dni);
    }
}
