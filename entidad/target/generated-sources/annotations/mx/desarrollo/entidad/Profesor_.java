package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.UnidadAprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-05T12:17:49")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> apellidoPaterno;
    public static volatile ListAttribute<Profesor, UnidadAprendizaje> unidadAprendizajeList;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, Integer> idprofesor;
    public static volatile SingularAttribute<Profesor, String> rfc;
    public static volatile SingularAttribute<Profesor, String> apellidoMaterno;

}