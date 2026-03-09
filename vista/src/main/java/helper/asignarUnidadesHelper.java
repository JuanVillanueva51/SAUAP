/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import mx.desarrollo.sauap.entity.Asignacion;
import mx.desarrollo.sauap.negocio.integration.ServiceFacadeLocator;

import java.io.Serializable;

public class asignarUnidadesHelper implements Serializable {

    public void asignarUnidades(Asignacion asignacion){
        ServiceFacadeLocator.getInstanceAsignacionFacade().asignarUnidad(asignacion);
    }

}
