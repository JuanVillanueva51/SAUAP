/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.sauap.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.sauap.dao.*;
import mx.desarrollo.sauap.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static AsignacionDAO asignacionDAO;
    private static ProfesorDAO profesorDAO;
    private static UsuarioDAO usuarioDAO;
    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }
    public static AsignacionDAO getInstanceAsignacionDAO(){
        if(asignacionDAO == null){
            asignacionDAO = new AsignacionDAO(getEntityManager());
            return asignacionDAO;
        } else{
            return asignacionDAO;
        }
    }

    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO(getEntityManager());
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO(getEntityManager());
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
}
