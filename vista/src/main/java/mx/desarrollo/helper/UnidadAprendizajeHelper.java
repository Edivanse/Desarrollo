/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.util.List;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author marce
 */
public class UnidadAprendizajeHelper {

    public UnidadAprendizajeHelper() {

    }

    public void registrar(UnidadAprendizaje unidad) {
        ServiceFacadeLocator.getInstanceFacadeUnidadArendizaje().saveUnidad(unidad);
    }

    public List<UnidadAprendizaje> consultar() {
        return ServiceFacadeLocator.getInstanceFacadeUnidadArendizaje().consultar();
    }

    public void eliminarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        ServiceFacadeLocator.getInstanceFacadeUnidadArendizaje().eliminarUnidadAprendizaje(unidadAprendizaje);
    }

    public void modificar(UnidadAprendizaje unidadAprendizaje) {
        ServiceFacadeLocator.getInstanceFacadeUnidadArendizaje().modificarUnidadAprendizaje(unidadAprendizaje);
    }
}
