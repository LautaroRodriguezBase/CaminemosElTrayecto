package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.AdministradorCurso;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import java.util.ArrayList;

public class Docente extends User implements Sancionable, AdministradorCurso {

    private String nombre;

    private String apellido;

    private String dni;

    private int numTelefono;

    private ArrayList<Curso> cursosCreados;

    public Docente(String nombre, String apellido, String dni, int numTelefono, ArrayList<Curso> cursosCreados, String uName, String uPass) {
        super(uName, uPass);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numTelefono = numTelefono;
        this.cursosCreados = cursosCreados;
    }

    
    public void addCurso(Curso curso) {
        cursosCreados.add(curso);
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
        boolean resultado = false;
        return resultado;
    }
    
    public boolean esDocente(User u) {
        boolean resultado = false;
        
        if(u.getClass().getName().equals("Docente")){
            resultado = true;
        }else{
            resultado = false;
        }
        
        return resultado;
    }
    
    public boolean esAlumno(User u){
        boolean resultado = false;
        return resultado;
    }

    @Override
    public void cambiarEstadoDelCurso(Curso c, int estado) {
        if(estado >= 0 && estado < 4){
            c.cambiarEstado(estado);
        }
    }
}
