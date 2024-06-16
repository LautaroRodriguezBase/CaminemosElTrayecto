package com.iset.caminemoseltrayecto;

import java.io.EOFException;
import java.io.IOException;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.iset.caminemoseltrayecto.modelos.Curso;
import com.iset.caminemoseltrayecto.modelos.Admin;
import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.ContraseñaInvalidaException;
import com.iset.caminemoseltrayecto.modelos.Docente;
import com.iset.caminemoseltrayecto.modelos.EstadoNoValidoException;
import com.iset.caminemoseltrayecto.modelos.User;
import com.iset.caminemoseltrayecto.modelos.UsuarioNoExisteException;
import com.iset.caminemoseltrayecto.visual.AdminFrame;
import java.util.ArrayList;
import com.iset.caminemoseltrayecto.visual.LogIn;
import com.iset.caminemoseltrayecto.visual.Sancionable;
import java.io.File;

public class CaminemosElTrayecto {
    private static FileOutputStream fileOut;
    private static ObjectOutputStream output;

    private static FileInputStream fileIn;
    private static ObjectInputStream input;

    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    private static ArrayList<User> usuarios = new ArrayList<User>();
    private static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private static ArrayList<Docente> docentes = new ArrayList<Docente>();

    private static Admin admin;

    public static void main(String[] args) throws IOException, ClassNotFoundException{//Ademas aca deberia cargar a todos los usuarios, cursos y demas
        CaminemosElTrayecto.cursos = CaminemosElTrayecto.readInFile("cursos.dat");
        CaminemosElTrayecto.alumnos = CaminemosElTrayecto.readInFile("alumnos.dat");
        CaminemosElTrayecto.docentes = CaminemosElTrayecto.readInFile("docentes.dat");
                
        new LogIn().setVisible(true);
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
    public static ArrayList<Curso> getCursos(){
        return CaminemosElTrayecto.cursos;
    }
    public static User existe(String uName, String uPass) throws IOException, ClassNotFoundException {
        User us = readInFile();
        CaminemosElTrayecto.usuarios.add(us);//Lee el admin
        
        for(Docente d : docentes/*readInFileD("docentes.dat")*/){
            CaminemosElTrayecto.docentes.add(d);
            User nU = d;
            CaminemosElTrayecto.usuarios.add(nU);
        }
        
        for(Alumno a : alumnos/*readInFileA("alumnos.dat")*/){
            User nU = a;
            CaminemosElTrayecto.usuarios.add(nU);
        }
        /*
        Antes de eso tiene que llenar el array de usuarios leyendolo del archivo.
        Para eso tiene que haber un archivo con todas las opciones, de usuarios, de almnos, etc.
        A su vez tiene que haber archivos de respaldo de los anteriores.
        En caso de fallar levanta el original, levanta el de respaldo, elimina al original, y lo recrea de nuevo.
        Estos archivos deberian estar en carpetas separadas.
        */
        boolean userExist = false;
        for(User u : CaminemosElTrayecto.usuarios){
            if(u.getUserName().equals(uName) && u.getUserPass().equals(uPass)){
                userExist = true;// creo que no es tan necesario porque el return corta la ejecucion
                return u;
            }
        }
        if(!userExist){
            throw new UsuarioNoExisteException("No existe el usuario");//Crear un archivo de idiomas para los Strings y demas
        }
        return null;
    }
    public static boolean ingresar(String tfU, String tfP) throws IOException, ClassNotFoundException{
        try{
            User u = existe(tfU, tfP);
            
            if(u.esAdmin(u)){
                Admin a = (Admin) u;
                a.mostrarVentana();
                return true;
            }else if(u.esDocente(u)){
                Docente d = (Docente) u;
                d.mostrarVentana();
                return true;
            }else{
                Alumno a = (Alumno) u;
                a.mostrarVentana();
                return true;
            }
        }catch(UsuarioNoExisteException userNotFound){
            throw new UsuarioNoExisteException("No existe el usuario");//Crear un archivo de idiomas para los Strings y demas
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
        //Solo es necesario escribir users y cursos

    /**
     *
     * @param archivo
     * @param list
     * @throws IOException
     */
    public static <T> void writeInFile(String archivo, ArrayList<T> list) throws IOException{
        try{
             fileOut = new FileOutputStream(archivo);
             output = new ObjectOutputStream(fileOut);
             
             if (output != null) {
                output.writeObject(list);
                output.close();
            }
        }catch(IOException e){
            System.out.println("No anduvo writeInFile\n" + e);//mandarle a la visual para que muestre algo
        }finally{
            if (output != null) {
                output.close();
            }
        }
    }

        //lee los users y cursos
    /**
     *
     * @param <T>
     * @param archivo
     * @param clase
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> readInFile(String archivo) throws IOException, ClassNotFoundException{
        try{
            fileIn = new FileInputStream(archivo);
            if(fileIn.available() == 0){
                writeInFile(archivo, new ArrayList<T>());
            }
            input = new ObjectInputStream(fileIn);
             
            if (input != null) {
                return (ArrayList<T>)input.readObject();
            }else{
                return new ArrayList<T>();
            }

        }catch(EOFException e){
            System.out.println("No anduvo readInFile" + (archivo.equals("alumnos.dat")?"A":(archivo.equals("docentes.dat")?"D":"C")) + e);
            return new ArrayList<T>();
        }finally{
            if (input != null) {
                input.close();
            }
        }
    }

    //Lee el archivo de admin
    public static User readInFile() throws IOException, ClassNotFoundException{
        try{
            fileIn = new FileInputStream("admin.dat");
            input = new ObjectInputStream(fileIn);
             
            if (input != null) {
                return (User) input.readObject();
            }

        }catch(EOFException e){
            System.out.println("No anduvo admin");
        }finally{
            if (input != null) {
                input.close();
            }
        }
        return null;
    }
    
// Funcionesd del Admin
    public static void habilitarCurso(Curso c) throws EstadoNoValidoException{//la ejecuta el administrador.
                                               //Deberia tambien el Docente pero la visual deberia mostrarle solo los cerrados
        c.cambiarEstado("Habilitado");//el estado del curso deberia ser un int, y de ahi asociarlo a un Stirng
    }
        //Medio al pedo la de arriba si basicamente lo hace la de abajo. El nombre de la de arriba tiene que ir en el btn de la visual
    public static void cambiarEstadoDelCurso(Curso c, String estado) throws EstadoNoValidoException {
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
    public static ArrayList<Alumno> getAlumnos(){
        return CaminemosElTrayecto.alumnos;
    }
    public static void addAlumno(Alumno a){
        CaminemosElTrayecto.alumnos.add(a);
    }
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
            throw new ContraseñaInvalidaException("La contraseña que a ingresado es invalida");
        }
    }
    
    // Funciones del Docente
    public static ArrayList<Docente> getDocentes(){
        return CaminemosElTrayecto.docentes;
    }
    public static void addDocente(Docente d){
        CaminemosElTrayecto.docentes.add(d);
    }
    public static void addCurso(Docente d, Curso c) throws IOException, ClassNotFoundException{//No se si es a los docentes, al alumno, a la propia universidad
        /*  No deberia ser necesario por el tema de que ya se cargan con el programa en el main
            CaminemosElTrayecto.cursos = CaminemosElTrayecto.readInFileC("cursos.dat");
            CaminemosElTrayecto.docentes = CaminemosElTrayecto.readInFileD("docentes.dat");
        */
        cursos.add(c);
        d.addCurso(c);
        int posDocente = -1;
        for(int i = 0; i < CaminemosElTrayecto.docentes.size();i++){
            if(CaminemosElTrayecto.docentes.get(i).getDni().equals(d.getDni())){//Creo que un contains hace lo mismo
                posDocente = i;
            }
        }//Habria que agregar un if que lance una excepcion si la posDocente es -1
        CaminemosElTrayecto.docentes.get(posDocente).addCurso(c);
        CaminemosElTrayecto.writeInFile("cursos.dat", cursos);
        CaminemosElTrayecto.writeInFile("docentes.dat", docentes);
    }
    public static void proponerCurso(Docente d, Curso c){//la ejecuta el docente
        d.addCurso(c); //no deberia retornar nada
    }
    public static void finalizarCurso(Curso c, ArrayList<Alumno> alumnosAprobados) throws EstadoNoValidoException{//El array list que recibe es de los alumnos aprobados
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
