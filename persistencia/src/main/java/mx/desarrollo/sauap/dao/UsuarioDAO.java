package mx.desarrollo.sauap.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.entity.Usuario;
import mx.desarrollo.sauap.persistence.AbstractDAO;

    public class UsuarioDAO extends AbstractDAO<Usuario> {
        private final EntityManager entityManager;

        public UsuarioDAO(EntityManager em) {
            super(Usuario.class);
            this.entityManager = em;
        }
        @Override
        public EntityManager getEntityManager() {
            return entityManager;
        }
        public Usuario buscarCredenciales(String usuario, String contrasena){
          try{
              return entityManager.createQuery(
                      "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasena = :contrasena", Usuario.class
              ).setParameter("nombreUsuario", usuario)
                      .setParameter("contrasena", contrasena)
                      .getSingleResult();
          }catch(Exception e){
              return null;
          }
        }
    }

