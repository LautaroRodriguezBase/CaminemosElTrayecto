package com.iset.caminemoseltrayecto.visual;

import com.iset.caminemoseltrayecto.modelos.Curso;
import com.iset.caminemoseltrayecto.modelos.EstadoNoValidoException;

public interface AdministradorCurso {

    public void cambiarEstadoDelCurso(Curso c, String estado) throws EstadoNoValidoException;
}
