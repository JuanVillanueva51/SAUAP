package mx.desarrollo.sauap.negocio.integration;


import mx.desarrollo.sauap.negocio.facade.AsignacionFacade;

import mx.desarrollo.sauap.negocio.delegate.UsuarioDelegate;
import mx.desarrollo.sauap.negocio.facade.ProfesorFacade;

public class ServiceFacadeLocator {

    private static AsignacionFacade asignacionFacade;

    public static AsignacionFacade getInstanceAsignacionFacade() {
        if (asignacionFacade == null) {
            asignacionFacade = new AsignacionFacade();
            return asignacionFacade;
        } else {
            return asignacionFacade;
        }
    }
    private static ProfesorFacade profesorFacade;
    private static UsuarioDelegate usuarioDelegate;

    public static ProfesorFacade getInstanceProfesorFacade() {
        if (profesorFacade == null) {
            profesorFacade = new ProfesorFacade();
            return profesorFacade;
        } else {
            return profesorFacade;
        }
    }
    public static UsuarioDelegate getInstanceUsuarioDelegate() {
        if(usuarioDelegate == null) {
            usuarioDelegate = new UsuarioDelegate();
            return usuarioDelegate;
        } else{
            return usuarioDelegate;
        }
    }
}
