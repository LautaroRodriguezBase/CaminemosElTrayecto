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


    public void addAlumnoAlCurso(Alumno a, Curso c) {
        if(a != null && c != null){
            c.addAlumno(a);// Tambien se tiene que actualizar el archivo
        }// Lanzar una excepcion
    }

    //Hacer polimorfismo del tipo sobrecarga de funciones para que alcance a todas las opciones
    public void addCurso(){//No se si es a los docentes, al alumno, a la propia universidad
        
    }

    public User existe(String uName, String uPass) {
        /*
        Antes de eso tiene que llenar el array de usuarios leyendolo del archivo.
        Para eso tiene que haber un archivo con todas las opciones, de usuarios, de almnos, etc.
        A su vez tiene que haber archivos de respaldo de los anteriores.
        En caso de fallar levanta el original, levanta el de respaldo, elimina al original, y lo recrea de nuevo.
        Estos archivos deberian estar en carpetas separadas.
        */
        
        for(User u : this.usuarios){
            if(u.getUserName().equals(uName) && u.getUserPass().equals(uPass)){
                return u;
            }
        }
        //Crear excepciones para estos casos
        throw new UnsupportedOperationException("No existe el usuario");//Crear un archivo de idiomas para los Strings y demas
    }

    public ArrayList verCursosDisponibles(Alumno a){
        ArrayList<Curso> cursosDisponibles = new ArrayList<Curso>();
        
        for(Curso c : this.cursos){
            Curso [] cursosPrevios = c.getCursosPrevios();
            
            switch(cursosPrevios.length){
                case 0:
                    cursosDisponibles.add(c);//Se muestrasn como disponibles los que no tienen cursos previos
                    break;
                case 1:
                    if(a.getCursosAprobados().contains(cursosPrevios[0])){
                        cursosDisponibles.add(c);
                    }
                    break;
                case 2:
                    if(a.getCursosAprobados().contains(cursosPrevios[0]) && a.getCursosAprobados().contains(cursosPrevios[1])){
                        cursosDisponibles.add(c);
                    }
                    break;
            }
        }
        
        return cursosDisponibles;
    }

    public ArrayList<Curso> verCursosAprobados(Alumno a){
        return a.getCursosAprobados();
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
