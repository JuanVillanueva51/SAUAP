/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.registroProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.desarrollo.sauap.entity.Profesores;
import java.io.Serializable;

@Named("registroProfesorUI")
@SessionScoped
public class registroProfesorBeanUI implements Serializable {
    private registroProfesorHelper registroProfesorHelper;
    private Profesores profesor;

    public registroProfesorBeanUI() {
        registroProfesorHelper = new registroProfesorHelper();
    }
@PostConstruct public void init() { profesor = new Profesores(); }

    public void registrarProfesor() {
        try {
            registroProfesorHelper.registrarProfesor(profesor);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Profesor agregado con exito"));

            profesor = new Profesores();
        } catch (IllegalArgumentException e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", String.valueOf(e.getMessage())));
        } catch (Exception e) {
            String mensaje = "Error al registrar profesor";
            if(e.getMessage() != null && e.getMessage().contains("RFC_UNIQUE"))
            {
                mensaje = "RFC ya existente en el sistema";
            }
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
        }
    }
    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
}
