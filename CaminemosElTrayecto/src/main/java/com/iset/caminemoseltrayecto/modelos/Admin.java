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
        if(a != null){
            alumnos.add(a);
        }else{
            throw new NullPointerException("El alumno que a ingresado no es valido");
        }
    }

    public void addDocente(Docente d){
        if(d != null){
            docentes.add(d);
        }else{
            throw new NullPointerException("El alumno que a ingresado no es valido");
        }
    }

    public void sancionPara(Sancionable s){
        if(s != null){
            s.sancionar();
        }else{
            throw new NullPointerException("El usuario que a ingresado no es valido");
        }
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
