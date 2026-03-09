package helper;

import mx.desarrollo.sauap.entity.Usuario;
import mx.desarrollo.sauap.negocio.integration.ServiceFacadeLocator;

public class loginHelper {
    public Usuario validarUsuario(String usuario, String contrasena){
        return ServiceFacadeLocator.getInstanceUsuarioDelegate().validarUsuario(usuario,contrasena);
    }
}
