package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.Reseteable;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import com.iset.caminemoseltrayecto.visual.AlumnoFrame;

import java.util.ArrayList;

public class Alumno extends User implements Sancionable, Reseteable{//era necesaria una clase intermedia para alumno y docente

    private String nombre, apellido, dni, numTelefono;

    private int estado = NORMAL;//Podria ser varios ademas de sancionado, como "en revision", "en mantenimiento", etc

    private ArrayList<Curso> cursosAprobados = new ArrayList<Curso>();
    private ArrayList<Curso> cursosInscriptos = new ArrayList<Curso>();

    public Alumno(String uName, String uPass, String nombre, String apellido, String dni, String numTelefono){// El nmero de cel esta de mas
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
    
    public void addCursoAprobado(Curso c){
        if(c != null){
            cursosAprobados.add(c);//faltaria cambiar los array list por una lista que no permita repetidos
        }else{
            throw new NullPointerException("El curso que a ingresado no es valido");
        }
    }
    
    public void addCursoInscripto(Curso c){
        if(c != null){
            cursosInscriptos.add(c);
        }else{
            throw new NullPointerException("El curso que a ingresado no es valido");
        }
    }
    
    public void removeCursoInscripto(Curso c){
        if(c != null){
            cursosInscriptos.remove(c);
        }else{
            throw new NullPointerException("El curso que a ingresado no es valido");
        }
    }
    
    
    //Sancionable
    public void sancionar() {
        this.estado = SANCIONADO;
    }
    public void quitarSancion() {
        this.estado = NORMAL;
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

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
