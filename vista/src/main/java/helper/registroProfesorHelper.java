/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.Serializable;
import mx.desarrollo.sauap.negocio.integration.ServiceFacadeLocator;
import mx.desarrollo.sauap.entity.Profesores;
public class registroProfesorHelper implements Serializable {
    
    public void registrarProfesor(Profesores profesor){
        ServiceFacadeLocator.getInstanceProfesorFacade().guardarProfesor(profesor);
    }

    
}
