package mx.desarrollo.sauap.negocio.integration;


import mx.desarrollo.sauap.negocio.facade.ProfesorFacade;

public class ServiceFacadeLocator {

    private static ProfesorFacade profesorFacade;

    public static ProfesorFacade getInstanceProfesorFacade() {
        if (profesorFacade == null) {
            profesorFacade = new ProfesorFacade();
            return profesorFacade;
        } else {
            return profesorFacade;
        }
    }
}
