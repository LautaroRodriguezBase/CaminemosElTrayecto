package com.iset.caminemoseltrayecto.modelos;

public class ContraseñaInvalidaException extends RuntimeException{

    public ContraseñaInvalidaException() {
    }

    public ContraseñaInvalidaException(String message) {
        super(message);
    }

    public ContraseñaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContraseñaInvalidaException(Throwable cause) {
        super(cause);
    }

    public ContraseñaInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
