package mx.desarrollo.sauap.negocio.delegate;

import mx.desarrollo.sauap.entity.Usuario;
import mx.desarrollo.sauap.integration.ServiceLocator;

public class UsuarioDelegate {
    public Usuario validarUsuario(String usuario, String contrasena){
        try{
            return ServiceLocator.getInstanceUsuarioDAO().buscarCredenciales(usuario, contrasena);
        }catch(Exception ex){
          throw new IllegalArgumentException("Usuario no encontrado");
        }
    }
}
