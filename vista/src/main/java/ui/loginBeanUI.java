package ui;

import helper.loginHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.sauap.entity.Usuario;

import java.io.Serializable;

@Named("loginUI")
@SessionScoped
public class loginBeanUI implements Serializable {
    private Usuario user;
    private String usuario;
    private String contrasena;
    private loginHelper loginHelper;

    public loginBeanUI() {
        loginHelper = new loginHelper();
    }
    public void iniciarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            user = loginHelper.validarUsuario(usuario, contrasena);
            if(user != null){
                context.getExternalContext().getSessionMap().put("usuarioSesion", usuario);
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Sesion iniciada"));
                context.getExternalContext().redirect("menuInicio.xhtml");
            } else{
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales invalidas");
            }
        }catch(Exception ex){
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage());
        }
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
