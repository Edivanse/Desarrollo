/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.BeanUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.helper.ProfesorHelper;

/**
 *
 * @author marce
 */
@ManagedBean(name = "ProfesorBeanUI")
@SessionScoped
public class ProfesorBeanUI implements Serializable {

    private ProfesorHelper profesorhelper;
    private Profesor profesor;
    private List<Profesor> profesores;
    private Profesor profesorSeleccionado;
    private FacadeProfesor facadeProfesor;
    private List<String> unidadselec;

    public ProfesorBeanUI() {
        profesorhelper = new ProfesorHelper();
        profesor = new Profesor();
        profesores = new ArrayList<Profesor>();
        profesores = profesorhelper.consultar();
        facadeProfesor = new FacadeProfesor();
        unidadselec = new ArrayList<String>();
    }

    public void actualizar() {
        profesor = new Profesor();
        profesores = profesorhelper.consultar();
        facadeProfesor = new FacadeProfesor();
        unidadselec = new ArrayList<String>();
        profesorSeleccionado = new Profesor();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void guardar() {

        for (Profesor p : profesores) {
            if (p.getIdprofesor() == profesor.getIdprofesor()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe ese ID"));
                return;
            }
        }

        if (profesor.getNombre().isEmpty() || profesor.getApellidoPaterno().isEmpty() || profesor.getApellidoMaterno().isEmpty() || profesor.getRfc().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            return;
        }

        if (profesor.getNombre().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener numeros"));
            return;
        }

        if (profesor.getApellidoPaterno().matches(".*\\d.*") || profesor.getApellidoMaterno().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "Los apellidos no pueden contener números"));
            return;
        }

        String idProfesorStr = String.valueOf(profesor.getIdprofesor());

        if (!idProfesorStr.matches("\\d+")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El ID solo puede tener numeros"));
            return;
        }
        if (idProfesorStr.length() > 6) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "?", "Solo puedes ingresar maximo 6 digitos"));
            return;
        }

        if (profesor.getRfc().length() != 13) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mal", "El RFC es solamente de 13 caracteres"));
            return;
        }

        // Si pasa todas las validaciones, guardar el profesor
        Seleccion();
        profesorhelper.registrar(profesor);
        actualizar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
    }

    public void eliminarProfesor() {
        if (profesorSeleccionado != null) {
            facadeProfesor.eliminarProfesor(profesorSeleccionado);
            profesores = facadeProfesor.consultar();
            profesorSeleccionado = null;
        }
    }

    public void modificar() {

        if (profesorSeleccionado.getNombre().isEmpty() || profesorSeleccionado.getApellidoPaterno().isEmpty() || profesorSeleccionado.getApellidoMaterno().isEmpty() || profesorSeleccionado.getRfc().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            return;
        }

        if (profesorSeleccionado.getNombre().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "El nombre no puede contener números"));
            return;
        }

        if (profesorSeleccionado.getApellidoPaterno().matches(".*\\d.*") || profesorSeleccionado.getApellidoMaterno().matches(".*\\d.*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No", "Los apellidos no pueden contener números"));
            return;
        }

        if (profesorSeleccionado.getRfc().length() != 13) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mal", "El RFC es solamente de 13 caracteres"));
            return;
        }

        // Si pasa todas las validaciones, guardar el profesor
        Seleccion();
        profesorhelper.modificar(profesorSeleccionado);
        actualizar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion exitosa", null));
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }

    public List<String> getUnidadselec() {
        return unidadselec;
    }

    public void setUnidadselec(List<String> unidadselec) {
        this.unidadselec = unidadselec;
    }

    public void Seleccion() {
        List<UnidadAprendizaje> unidad = new ArrayList<>();
        for (String x : unidadselec) {
            unidad.add(new UnidadAprendizaje(Integer.parseInt(x)));
        }
        profesor.setUnidadAprendizajeList(unidad);
    }

}
