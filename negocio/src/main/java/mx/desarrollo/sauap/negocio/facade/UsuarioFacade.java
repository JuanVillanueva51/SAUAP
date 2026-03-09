package mx.desarrollo.sauap.negocio.facade;

import mx.desarrollo.sauap.dao.UsuarioDAO;
import mx.desarrollo.sauap.entity.Usuario;
import mx.desarrollo.sauap.negocio.delegate.UsuarioDelegate;

public class UsuarioFacade {
    private UsuarioDelegate usuarioDelegate;
    public UsuarioFacade(){
        usuarioDelegate = new UsuarioDelegate();
    }
    public Usuario validarUsuario(String usuario, String contrasena){
        return usuarioDelegate.validarUsuario(usuario,contrasena);
    }
}
