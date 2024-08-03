package com.iset.caminemoseltrayecto.visual;

public interface Sancionable {
    public static final int SANCIONADO = 1;
    public static final int NORMAL = 0;
    
    public void sancionar();
    public void quitarSancion();
}
