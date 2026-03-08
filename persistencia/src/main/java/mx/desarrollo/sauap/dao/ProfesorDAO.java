package mx.desarrollo.sauap.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.persistence.AbstractDAO;

import java.util.List;

public class ProfesorDAO extends AbstractDAO<Profesores> {
    private final EntityManager entityManager;

    public ProfesorDAO(EntityManager em) {
        super(Profesores.class);
        this.entityManager = em;
    }
    public void  guardarProfesor(Profesores profesor){
        save(profesor);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
