package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.AdministradorCurso;
import com.iset.caminemoseltrayecto.visual.Reseteable;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import com.iset.caminemoseltrayecto.visual.DocenteFrame;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Docente extends User implements Sancionable, Reseteable, AdministradorCurso{

    private String nombre, apellido, dni, numTelefono = "";
    
    private int estado = 0;//Podria ser varios ademas de sancionado, como "en revision", "en mantenimiento", etc
    
    private ArrayList<Curso> cursosCreados = new ArrayList<Curso>();

    public Docente(String uName, String uPass, String nombre, String apellido, String dni){// La uPass esta de mas porque deberia ser el dni
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
        if(curso != null){
            
            this.cursosCreados.add(curso);
        }else{
            throw new NullPointerException("El curso que a ingresado no es valido");
        }
    }
    
    @Override
    public void cambiarEstadoDelCurso(Curso c, String estado) throws EstadoNoValidoException{
    //Creo que no se necesita
        c.cambiarEstado(estado);
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
        try {// Esta mal el objeto creo que no puede invocar la ventana
            new DocenteFrame(this).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Docente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Docente.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
