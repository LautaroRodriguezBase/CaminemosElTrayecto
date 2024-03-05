package com.iset.caminemoseltrayecto.modelos;

public abstract class User {

    private String userName, userPass;

    public User(String uName, String uPass){
        this.userName = uName;
        this.userPass = uPass;
    }

    public void setUserName(String name) {
        userName = name;
    }
    public void setUserPass(String pass) {
        userPass = pass;
    }

    public String getUserName() {
        return this.userName;
    }
    public String getUserPass() {
        return this.userPass;
    }

    public abstract boolean esAdmin(User u);
    public abstract boolean esDocente(User u);
    public abstract void mostrarVentana();
}
