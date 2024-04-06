package com.iset.caminemoseltrayecto.modelos;

public class EstadoNoValidoException extends Exception{

    public EstadoNoValidoException() {
    }

    public EstadoNoValidoException(String message) {
        super(message);
    }

    public EstadoNoValidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EstadoNoValidoException(Throwable cause) {
        super(cause);
    }

    public EstadoNoValidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
