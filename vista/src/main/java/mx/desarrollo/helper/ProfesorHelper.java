/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author marce
 */
public class ProfesorHelper implements Serializable {

    public ProfesorHelper() {

    }

    public void registrar(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);
    }

    public List<Profesor> consultar() {
        List<Profesor> lista = ServiceFacadeLocator.getInstanceFacadeProfesor().consultar();
        if (lista.size() > 0) {
            Collections.sort(lista, new Comparator<Profesor>() {
                @Override
                public int compare(final Profesor object1, final Profesor object2) {
                    return object1.getApellidoPaterno().compareToIgnoreCase(object2.getApellidoPaterno());
                }
            });
        }
        return lista;
    }

    public void eliminarProfesor(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().eliminarProfesor(profesor);
    }

    public void modificar(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().modificarProfesor(profesor);
    }

}
