package com.iset.caminemoseltrayecto;

import com.iset.caminemoseltrayecto.modelos.Curso;
import com.iset.caminemoseltrayecto.modelos.Admin;
import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.Docente;
import com.iset.caminemoseltrayecto.modelos.User;
import com.iset.caminemoseltrayecto.modelos.UsuarioNoExisteException;
import com.iset.caminemoseltrayecto.visual.AdminFrame;
import java.util.ArrayList;
import com.iset.caminemoseltrayecto.visual.LogIn;
import com.iset.caminemoseltrayecto.visual.Sancionable;

public class CaminemosElTrayecto {

    //private String nombre;// no se para que culo es esto

    private static ArrayList<Alumno> alumnos;
    private static ArrayList<Docente> docentes;
    private static ArrayList<Curso> cursos;
    private static ArrayList<User> usuarios;

    private Admin admin;

    public static void main(String[] args) {//Ademas aca deberia cargar a todos los usuarios, cursos y demas
        new LogIn().setVisible(true);
        //li.setLocationRelativeTo(null);
    }

    //creo que todas las funciones deberian ser static para invocarlas desde otro archivo
    /*
     Hay que ir acomodando las funciones en base a quien las puede llamar.
     Sumado a esto el controlador tiene que tener todas las funciones de los modelos
     ya que la visual invoca al controlador y este al modelo.
     No todas son exclusivas de la clase ya que pueden ser invocadas por el admin.
     Es para tener una referencia
     */
    // Funciones del Controlador
    public static User existe(String uName, String uPass) {
        /*
        Antes de eso tiene que llenar el array de usuarios leyendolo del archivo.
        Para eso tiene que haber un archivo con todas las opciones, de usuarios, de almnos, etc.
        A su vez tiene que haber archivos de respaldo de los anteriores.
        En caso de fallar levanta el original, levanta el de respaldo, elimina al original, y lo recrea de nuevo.
        Estos archivos deberian estar en carpetas separadas.
        */
        
        for(User u : CaminemosElTrayecto.usuarios){
            if(u.getUserName().equals(uName) && u.getUserPass().equals(uPass)){
                return u;
            }
        }
        //Crear excepciones para estos casos
        throw new UsuarioNoExisteException("No existe el usuario");//Crear un archivo de idiomas para los Strings y demas
    }
    public static boolean ingresar(String tfU, String tfP){
        //Faltaria definir bien como funciona con la funcion "existe("
        if(tfU.equals("Admin") && tfP.equals("1234")){
            new AdminFrame(new Admin(tfU, tfP)).setVisible(true);
            return true;
        }else{// teoricamente aca deberia lanzar una excepcion
            return false;
        }
    }
            //Esta pertenece al Controlador
    private static ArrayList<Curso> getCursosConEstadoEn(ArrayList<Curso> cursosConEstadoEn, String estado){
        for(Curso c : CaminemosElTrayecto.cursos){
            if(c.getEstadoCurso().equals(estado)){
                cursosConEstadoEn.add(c);
            }
        }
        return cursosConEstadoEn;
    }

    // Funcionesd del Admin
    public static void habilitarCurso(Curso c){//la ejecuta el administrador.
                                               //Deberia tambien el Docente pero la visual deberia mostrarle solo los cerrados
        c.cambiarEstado("Habilitado");//el estado del curso deberia ser un int, y de ahi asociarlo a un Stirng
    }
        //Medio al pedo la de arriba si basicamente lo hace la de abajo. El nombre de la de arriba tiene que ir en el btn de la visual
    public static void cambiarEstadoDelCurso(Curso c, String estado) {
        c.cambiarEstado(estado);
    }
    public static void blanquearPass(User u, String DNI){//hay dos opciones, o se pone el DNI como atributo de USER, o se pasa el DNI como parametro
        u.setUserPass(DNI);
    }
    public static void sancionarA(Sancionable s){
        s.sancionar();//EL docente y alumno deberian tener una variable para saber su estado o un bool para saber si estan sancionados
    }
    public static void quitarSancionA(Sancionable s){
        s.quitarSancion();
    }
    
    // Funciones del Alumno
    public static void addAlumnoAlCurso(Alumno a, Curso c) {
        if(a != null && c != null){
            c.addAlumno(a);// Tambien se tiene que actualizar el archivo
        }else{
            throw new NullPointerException("El curso y/o el alumno que a ingresado no es valido");
        }
    }
    
    public static ArrayList<Curso> verCursosDisponibles(Alumno a){
        ArrayList<Curso> cursosDisponibles = new ArrayList<Curso>();
        
        for(Curso c : CaminemosElTrayecto.cursos){
            Curso [] cursosPrevios = c.getCursosPrevios();
            
            switch(cursosPrevios.length){
                case 0 -> cursosDisponibles.add(c);//Se muestrasn como disponibles los que no tienen cursos previos
                
                case 1 -> {
                    if(a.getCursosAprobados().contains(cursosPrevios[0])){
                        cursosDisponibles.add(c);
                    }
                }
                
                case 2 -> {
                    if(a.getCursosAprobados().contains(cursosPrevios[0]) && a.getCursosAprobados().contains(cursosPrevios[1])){
                        cursosDisponibles.add(c);
                    }
                }
            }
        }
        
        return cursosDisponibles;
    }

    public static ArrayList<Curso> verCursosAprobados(Alumno a){
        return a.getCursosAprobados();
    }

    public static ArrayList<Curso> verCursosInscriptos(Alumno a){
        return a.getCursosInscriptos();
    }

        // Esta tambien la invoca el Docente y Admin
    public static void changePass(User u, String pass){
        if(!pass.equals("") && pass.length() >= 4){
            u.setUserPass(pass);
        }else{
            //lanza una excepcion
        }
    }
    
// Funciones del Docente
    public static void addCurso(Curso c){//No se si es a los docentes, al alumno, a la propia universidad
        //lo dejo como a la propia universidad, calculo que será llamada por otra funcion que complemente
        cursos.add(c);
    }
    public static void proponerCurso(Docente d, Curso c){//la ejecuta el docente
        d.addCurso(c); //no deberia retornar nada
    }
    public static void finalizarCurso(Curso c, ArrayList<Alumno> alumnosAprobados){//El array list que recibe es de los alumnos aprobados
        c.cambiarEstado("Finalizado");
        for(Alumno a : alumnosAprobados){
            a.addCursoAprobado(c);
        }
        for(Alumno a : c.getAlumnos()){
            a.removeCursoInscripto(c);
        }
    }

        //Estas dos funciones no aparecen en el UML
    public static ArrayList<Curso> verCursosHabilitados(Docente d){
        return getCursosConEstadoEn(d.getCursosCreados(), "Habilitado");//Crear final para los txt
    }
    public static ArrayList<Curso> verCursosCerrados(Docente d){
        return getCursosConEstadoEn(d.getCursosCreados(), "Cerrado");
    } 
}
