package com.iset.caminemoseltrayecto.modelos;

public class UsuarioNoExisteException extends RuntimeException{

    public UsuarioNoExisteException() {
    }

    public UsuarioNoExisteException(String message) {
        super(message);
    }

    public UsuarioNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNoExisteException(Throwable cause) {
        super(cause);
    }

    public UsuarioNoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    @Override
    public String toString(){
        
        return "No existe el usuario";
    }
}
