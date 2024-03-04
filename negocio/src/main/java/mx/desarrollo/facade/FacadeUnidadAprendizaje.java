/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entidad.UnidadAprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUnidadAprendizaje {

    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }
//    
//     /**
//     * Metodo para verificar si el usuario esta registrado en la bd
//     * @param password 
//     * @param correo
//     * @return Regresa usuario si el correo y contrasena con correctos
//     */
//    public UnidadAprendizaje login(String password, String correo){
//        return delegateUnidadAprendizaje.login(password, correo);
//    }

    /**
     * Metodo de ejemplo para guardar Unidad
     *
     * @param unidad de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUnidad(UnidadAprendizaje unidad) {
        delegateUnidadAprendizaje.saveUnidadAprendizaje(unidad);
    }

    public List<UnidadAprendizaje> consultar() {
        return delegateUnidadAprendizaje.consultar();
    }

    public void eliminarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        delegateUnidadAprendizaje.eliminarUnidadAprendizaje(unidadAprendizaje);
    }

    public void modificarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        delegateUnidadAprendizaje.updateUnidadAprendizaje(unidadAprendizaje);
    }

}
