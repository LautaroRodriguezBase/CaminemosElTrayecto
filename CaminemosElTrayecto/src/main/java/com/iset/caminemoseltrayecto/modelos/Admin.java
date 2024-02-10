package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.AdministradorCurso;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import java.util.ArrayList;

public class Admin extends User implements AdministradorCurso {

    //private static final int userType = 0;

    private static ArrayList<Alumno> alumnos;

    private static ArrayList<Docente> docentes;

    public Admin(String uName, String uPass) {
        super(uName, uPass);
    }

    public Alumno addAlumno(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Docente addDocente(Docente d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sancionable sancionPara(Sancionable s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarVentana() {
    }

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
