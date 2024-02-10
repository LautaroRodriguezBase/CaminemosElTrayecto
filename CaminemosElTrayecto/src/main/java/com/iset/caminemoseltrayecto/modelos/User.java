package com.iset.caminemoseltrayecto.modelos;

public abstract class User {

    private String userName, userPass;

    public User(String uName, String uPass){
        this.userName = userName;
        this.userPass = userPass;
    }

    public String setUserName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String setUserPass(String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getUserName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getUserPass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public abstract boolean esAdmin(User u);
    public abstract boolean esDocente(User u);
    public abstract void mostrarVentana();

    public String changePass(String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
