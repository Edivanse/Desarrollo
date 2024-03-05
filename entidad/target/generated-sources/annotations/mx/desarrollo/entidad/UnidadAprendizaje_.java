package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-05T12:17:49")
@StaticMetamodel(UnidadAprendizaje.class)
public class UnidadAprendizaje_ { 

    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasClase;
    public static volatile SingularAttribute<UnidadAprendizaje, String> nombreUnidad;
    public static volatile ListAttribute<UnidadAprendizaje, Profesor> profesorList;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> idunidadAprendizaje;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasTaller;

}