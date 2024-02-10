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

    
    public Curso addCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public String cambiarEstadoDelCurso(Curso c, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
