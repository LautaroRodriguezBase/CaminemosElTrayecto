package com.iset.caminemoseltrayecto.modelos;

import com.iset.caminemoseltrayecto.visual.AdministradorCurso;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import com.iset.caminemoseltrayecto.visual.AdminFrame;

import java.util.ArrayList;

public class Admin extends User implements AdministradorCurso {

    //private static final int userType = 0;

    private static ArrayList<Alumno> alumnos;
    private static ArrayList<Docente> docentes;

    public Admin(String uName, String uPass){
        super(uName, uPass);
    }

    public void addAlumno(Alumno a){
        //ademas debe guardarlo en el archivo y lanzar una excepcion en caso de fallar
        this.alumnos.add(a);
    }

    public void addDocente(Docente d){
        //ademas debe guardarlo en el archivo y lanzar una excepcion en caso de fallar
        this.docentes.add(d);
    }

    public void sancionPara(Sancionable s){
        s.sancionar();
    }

    //Implementa de Administrador de curso
    @Override
    public void cambiarEstadoDelCurso(Curso c, String estado){
    //Creo que no se necesita
        c.cambiarEstado(estado);
    }
    
    //Heredan de User
    @Override
    public boolean esAdmin(User u){
        return true;
    }
    @Override
    public boolean esDocente(User u){
        return false;
    }
    @Override
    public void mostrarVentana(){
        new AdminFrame(this).setVisible(true);
    }
}
