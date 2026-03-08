package mx.desarrollo.sauap.negocio.facade;

import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.negocio.delegate.ProfesorDelegate;
public class ProfesorFacade {
    private ProfesorDelegate profesorDelegate;

    public  ProfesorFacade() {
        this.profesorDelegate = new ProfesorDelegate();
    }
    public void guardarProfesor(Profesores profesor) {
        this.profesorDelegate.guardarProfesor(profesor);
    }
}
