/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidadAprendizaje {

//    /**
//     * Metodo para verificar si el usuario esta registrado en la bd
//     * @param password 
//     * @param correo
//     * @return un tipo usuario si no encuntra el usuario sera null
//     */
//    public UnidadAprendizaje login(String password, String correo){
//        UnidadAprendizaje unidad = new UnidadAprendizaje();
//        List<UnidadAprendizaje> usuarios = ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
//        
//        for(UnidadAprendizaje us:usuarios){
////            if(us.getContrasena().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
////                usuario = us;
////            }
////        }
////        return usuario;
//        if(us.getNombreUnidad().equalsIgnoreCase(password)) {
//            unidad = us;
//        }
//    }
//        return unidad;
//    }
//    
    /**
     * Metodo de ejemplo para guardar Unidad
     *
     * @param unidad de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUnidadAprendizaje(UnidadAprendizaje unidad) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidad);
    }

    public List<UnidadAprendizaje> consultar() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }

    public void eliminarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().delete(unidadAprendizaje);
    }

    public void updateUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().update(unidadAprendizaje);
    }

}
