package com.iset.caminemoseltrayecto;

import com.iset.caminemoseltrayecto.modelos.Curso;
import com.iset.caminemoseltrayecto.modelos.Admin;
import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.Docente;
import com.iset.caminemoseltrayecto.modelos.User;
import java.util.ArrayList;
import com.iset.caminemoseltrayecto.visual.LogIn;
import com.iset.caminemoseltrayecto.visual.Sancionable;

public class CaminemosElTrayecto {

    private String nombre;

    private ArrayList<Alumno> alumnos;
    private ArrayList<Docente> docentes;
    private ArrayList<Curso> cursos;
    private ArrayList<User> usuarios;

    private Admin admin;

    public static void main(String[] args) {
        LogIn li = new LogIn();
        li.setVisible(true);
        li.setLocationRelativeTo(null);
    }


    public Curso addAlumnoAlCurso(Alumno a, Curso c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addCurso() {
    }

    public User existe(String uName, String uPass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void verCursosDisponibles(Alumno a) {
    }

    public void verCursosAprobados(Alumno a) {
    }

    public Docente verCursosHabilitadosYCerrados(Docente d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Curso proponerCurso(Curso c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Curso habilitarCurso(Curso c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Alumno verCursosInscriptos(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean[] finalizarCurso(Curso c, ArrayList<Alumno> alumnos, boolean[] aprobados) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void blanquearPass(User u) {
    }

    public void cambiarEstadoDelCurso(Curso c, String estado) {
    }

    public void sancionar(Sancionable s) {
    }

    public void quitarSancion(Sancionable s) {
    }

    public void ingresar(String user, String pass) {
    }

    public void changePass(User u, String pass) {
    }
}
