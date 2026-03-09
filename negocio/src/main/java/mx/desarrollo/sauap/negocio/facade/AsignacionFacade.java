package mx.desarrollo.sauap.negocio.facade;

import mx.desarrollo.sauap.entity.Asignacion;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.entity.UnidadAprendizaje;
import mx.desarrollo.sauap.negocio.delegate.AsignacionDelegate;

import java.util.List;

public class AsignacionFacade {
    private final AsignacionDelegate asignacionDelegate;

    public AsignacionFacade(){
        this.asignacionDelegate = new AsignacionDelegate();
    }
    public void asignarUnidad(Asignacion asignacion ){
        asignacionDelegate.asignarUnidades(asignacion);
    }
    public List<Profesores> getProfesores(){
        return asignacionDelegate.getProfesores();
    }
    public List<UnidadAprendizaje> getUnidades(){
        return asignacionDelegate.getUnidades();
    }
}
