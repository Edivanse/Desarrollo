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

//    public void actualizar() {
//        profesor = new Profesor();
//        profesores = profesorhelper.consultar();
//        facadeProfesor = new FacadeProfesor();
//        unidadselec = new ArrayList<String>();
//        profesorSeleccionado = new Profesor();
//    }
    public void actualizar() {
        unidadAprendizaje = new UnidadAprendizaje();
        unidades = new ArrayList<UnidadAprendizaje>();
        unidades = unidadAprendizajehelper.consultar();
        unidadSeleccionada = new UnidadAprendizaje();
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

        String horasclase = String.valueOf(unidadAprendizaje.getHorasClase());
        String horastaller = String.valueOf(unidadAprendizaje.getHorasTaller());
        String horaslab = String.valueOf(unidadAprendizaje.getHorasLaboratorio());

        for (UnidadAprendizaje u : unidades) {
            if (u.getIdunidadAprendizaje() == unidadAprendizaje.getIdunidadAprendizaje()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe ese ID"));
                return;
            }
        }

        if (unidadAprendizaje.getNombreUnidad().isEmpty() || horasclase.isEmpty() || horastaller.isEmpty() || horaslab.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            return;
        }

        String id = String.valueOf(unidadAprendizaje.getIdunidadAprendizaje());

        if (!id.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El ID solo pueden contener numeros"));
            return;
        }

        if (!horasclase.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de clase solo pueden contener numeros"));
            return;
        }

        if (!horastaller.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de taller solo pueden contener numeros"));
            return;
        }

        if (!horaslab.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de laboratorio solo pueden contener numeros"));
            return;
        }

        if (unidadAprendizaje.getNombreUnidad().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener numeros"));
            return;
        }

        unidadAprendizajehelper.registrar(unidadAprendizaje);
        actualizar();
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

        String horasclase = String.valueOf(unidadAprendizaje.getHorasClase());
        String horastaller = String.valueOf(unidadAprendizaje.getHorasTaller());
        String horaslab = String.valueOf(unidadAprendizaje.getHorasLaboratorio());

        for (UnidadAprendizaje u : unidades) {
            if (u.getIdunidadAprendizaje() == unidadAprendizaje.getIdunidadAprendizaje()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe ese ID"));
                return;
            }
        }

        if (unidadAprendizaje.getNombreUnidad().isEmpty() || horasclase.isEmpty() || horastaller.isEmpty() || horaslab.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            return;
        }

        if (!horasclase.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de clase solo pueden contener numeros"));
            return;
        }

        if (!horastaller.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de taller solo pueden contener numeros"));
            return;
        }

        if (!horaslab.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas de laboratorio solo pueden contener numeros"));
            return;
        }

        if (unidadAprendizaje.getNombreUnidad().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener numeros"));
            return;
        }

        unidadAprendizajehelper.modificar(unidadAprendizaje);
        actualizar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion exitosa", null));
    }

    public UnidadAprendizaje getUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    public void setUnidadSeleccionada(UnidadAprendizaje unidadSeleccionada) {
        this.unidadSeleccionada = unidadSeleccionada;
    }

}
