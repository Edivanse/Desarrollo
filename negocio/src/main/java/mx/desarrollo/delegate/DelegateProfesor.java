/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author marce
 */
public class DelegateProfesor {

    /**
     * Metodo de ejemplo para guardar Unidad
     *
     * @param profesor de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }

    public List<Profesor> consultar() {
        return ServiceLocator.getInstanceProfesorDAO().findAll();
    }

    public void eliminarProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().delete(profesor);
    }
    
    public void updateProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().update(profesor);
    }

}
