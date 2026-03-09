package mx.desarrollo.sauap.negocio.integration;


import mx.desarrollo.sauap.negocio.facade.AsignacionFacade;

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
}
