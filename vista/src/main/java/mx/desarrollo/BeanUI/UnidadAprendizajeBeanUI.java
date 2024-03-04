/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.BeanUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.desarrollo.entidad.UnidadAprendizaje;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.desarrollo.facade.FacadeUnidadAprendizaje;
import mx.desarrollo.helper.UnidadAprendizajeHelper;

/**
 *
 * @author marce
 */
@ManagedBean(name = "UnidadAprendizajeBeanUI")
@SessionScoped
public class UnidadAprendizajeBeanUI implements Serializable {

    private UnidadAprendizajeHelper unidadAprendizajehelper;
    private UnidadAprendizaje unidadAprendizaje;
    private List<UnidadAprendizaje> unidades;
    private UnidadAprendizaje unidadSeleccionada;
    private FacadeUnidadAprendizaje facadeUnidadAprendizaje;

    public UnidadAprendizajeBeanUI() {
        unidadAprendizajehelper = new UnidadAprendizajeHelper();
        unidadAprendizaje = new UnidadAprendizaje();
        unidades = new ArrayList<UnidadAprendizaje>();
        unidades = unidadAprendizajehelper.consultar();
        unidadSeleccionada = new UnidadAprendizaje();
        facadeUnidadAprendizaje = new FacadeUnidadAprendizaje();
    }

    public UnidadAprendizajeHelper getUnidadAprendizajehelper() {
        return unidadAprendizajehelper;
    }

    public void setUnidadAprendizajehelper(UnidadAprendizajeHelper unidadAprendizajehelper) {
        this.unidadAprendizajehelper = unidadAprendizajehelper;
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }

    public List<UnidadAprendizaje> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadAprendizaje> unidades) {
        this.unidades = unidades;
    }

    public void guardar() {

        if (unidadAprendizaje.getHorasClase() <= 0 || unidadAprendizaje.getHorasTaller() <= 0 || unidadAprendizaje.getHorasLaboratorio() <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            return;
        }
        
        if (unidadAprendizaje.getNombreUnidad().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener numeros"));
            return;
        }

        String id = String.valueOf(unidadAprendizaje.getIdunidadAprendizaje());

        if (!id.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El ID solo pueden contener numeros"));
            return;
        }

        String horasclase = String.valueOf(unidadAprendizaje.getHorasClase());

        if (!horasclase.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de clase solo pueden contener numeros"));
            return;
        }

        String horastaller = String.valueOf(unidadAprendizaje.getHorasTaller());

        if (!horastaller.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de taller solo pueden contener numeros"));
            return;
        }

        String horaslab = String.valueOf(unidadAprendizaje.getHorasLaboratorio());

        if (!horaslab.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de laboratorio solo pueden contener numeros"));
            return;
        }

        unidadAprendizajehelper.registrar(unidadAprendizaje);
        unidadAprendizaje = new UnidadAprendizaje();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
    }

    public void eliminarUnidadAprendizaje() {
        if (unidadSeleccionada != null) {
            facadeUnidadAprendizaje.eliminarUnidadAprendizaje(unidadSeleccionada);
            unidades = facadeUnidadAprendizaje.consultar();
            unidadSeleccionada = null;
        }
    }

    public void modificarUnidad() {

//        if (unidadAprendizaje.getHorasClase() <= 0 || unidadAprendizaje.getHorasTaller() <= 0 || unidadAprendizaje.getHorasLaboratorio() <= 0) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
//            return;
//        }
//        if (unidadAprendizaje.getNombreUnidad().matches(".*\\d.*")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener numeros"));
//            return;
//        }

//        String id = String.valueOf(unidadAprendizaje.getIdunidadAprendizaje());
//
//        if (!id.matches("\\d+")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El ID solo pueden contener numeros"));
//            return;
//        }
//
//        String horasclase = String.valueOf(unidadAprendizaje.getHorasClase());
//
//        if (!horasclase.matches("\\d+")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de clase solo pueden contener numeros"));
//            return;
//        }
//
//        String horastaller = String.valueOf(unidadAprendizaje.getHorasTaller());
//
//        if (!horastaller.matches("\\d+")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de taller solo pueden contener numeros"));
//            return;
//        }
//
//        String horaslab = String.valueOf(unidadAprendizaje.getHorasLaboratorio());
//
//        if (!horaslab.matches("\\d+")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de laboratorio solo pueden contener numeros"));
//            return;
//        }

        unidadAprendizajehelper.modificar(unidadAprendizaje);
        unidadAprendizaje = new UnidadAprendizaje();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion exitosa", null));
    }

    public UnidadAprendizaje getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    public void setUnidadSeleccionada(UnidadAprendizaje unidadSeleccionada) {
        this.unidadSeleccionada = unidadSeleccionada;
    }

}
