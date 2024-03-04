/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadAprendizaje.findAll", query = "SELECT u FROM UnidadAprendizaje u")
    , @NamedQuery(name = "UnidadAprendizaje.findByIdunidadAprendizaje", query = "SELECT u FROM UnidadAprendizaje u WHERE u.idunidadAprendizaje = :idunidadAprendizaje")
    , @NamedQuery(name = "UnidadAprendizaje.findByNombreUnidad", query = "SELECT u FROM UnidadAprendizaje u WHERE u.nombreUnidad = :nombreUnidad")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasClase", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasTaller", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasLaboratorio", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idunidad_aprendizaje")
    private Integer idunidadAprendizaje;
    @Column(name = "nombreUnidad")
    private String nombreUnidad;
    @Column(name = "horasClase")
    private Integer horasClase;
    @Column(name = "horasTaller")
    private Integer horasTaller;
    @Column(name = "horasLaboratorio")
    private Integer horasLaboratorio;
    @ManyToMany(mappedBy = "unidadAprendizajeList")
    private List<Profesor> profesorList;

    public UnidadAprendizaje() {
    }

    public UnidadAprendizaje(Integer idunidadAprendizaje) {
        this.idunidadAprendizaje = idunidadAprendizaje;
    }

    public Integer getIdunidadAprendizaje() {
        return idunidadAprendizaje;
    }

    public void setIdunidadAprendizaje(Integer idunidadAprendizaje) {
        this.idunidadAprendizaje = idunidadAprendizaje;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadAprendizaje != null ? idunidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAprendizaje)) {
            return false;
        }
        UnidadAprendizaje other = (UnidadAprendizaje) object;
        if ((this.idunidadAprendizaje == null && other.idunidadAprendizaje != null) || (this.idunidadAprendizaje != null && !this.idunidadAprendizaje.equals(other.idunidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUnidad;
    }
    
}
