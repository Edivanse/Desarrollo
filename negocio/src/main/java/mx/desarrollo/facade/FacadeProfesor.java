/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeProfesor {

    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor) {
        delegateProfesor.saveProfesor(profesor);
    }

    public List<Profesor> consultar() {
        return delegateProfesor.consultar();
    }

    public void eliminarProfesor(Profesor profesor) {
        delegateProfesor.eliminarProfesor(profesor);
    }

    public void modificarProfesor(Profesor profesor) {
        delegateProfesor.updateProfesor(profesor);
    }

}
