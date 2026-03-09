package mx.desarrollo.sauap.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.sauap.entity.Asignacion;
import mx.desarrollo.sauap.entity.AsignacionId;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.entity.UnidadAprendizaje;
import mx.desarrollo.sauap.persistence.AbstractDAO;

import java.util.List;

public class AsignacionDAO extends AbstractDAO<Asignacion> {
    private final EntityManager entityManager;

    public AsignacionDAO(EntityManager em) {
        super(Asignacion.class);
        this.entityManager = em;
    }
    public void asignarUnidades(Asignacion asignacion){
        save(asignacion);
    }

    public List<Asignacion> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Asignacion a", Asignacion.class)
                .getResultList();
    }
    public List<Asignacion> buscarUnidadesYHoras(Integer idUnidad, Asignacion.TipoHora tipo){
        return entityManager
                .createQuery(
                        "SELECT a FROM Asignacion a "
                        + "WHERE a.idunidad.id = :idUnidad "
                        + "AND a.tipoHora = :tipo", Asignacion.class)
                .setParameter("idUnidad", idUnidad)
                .setParameter("tipo", tipo)
                .getResultList();
    }
    public List<Asignacion> buscarProfesorYDia(Integer idProfesor, Asignacion.Dia dia){
        return entityManager
                .createQuery(
                        "SELECT a FROM Asignacion a "
                                + "WHERE a.idprofesor.id = :idProfesor "
                                + "AND a.dia = :dia", Asignacion.class)
                .setParameter("idProfesor", idProfesor)
                .setParameter("dia", dia)
                .getResultList();
    }
    public List<Profesores> obtenerTodosProfesores() {
        return entityManager
                .createQuery("SELECT p FROM Profesores p", Profesores.class)
                .getResultList();
    }
    public List<UnidadAprendizaje> obtenerTodosUnidades() {
        return entityManager
                .createQuery("SELECT u FROM UnidadAprendizaje u", UnidadAprendizaje.class)
                .getResultList();
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
