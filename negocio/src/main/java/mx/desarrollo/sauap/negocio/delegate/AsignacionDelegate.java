package mx.desarrollo.sauap.negocio.delegate;

import mx.desarrollo.sauap.entity.Asignacion;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.entity.UnidadAprendizaje;
import mx.desarrollo.sauap.integration.ServiceLocator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class AsignacionDelegate {

    public void asignarUnidades(Asignacion asignacion) {
        validarVacios(asignacion);
        validarRangos(asignacion);
        validarHoras(asignacion);
        validarTraslape(asignacion);
        ServiceLocator.getInstanceAsignacionDAO().asignarUnidades(asignacion);
    }
    private void validarHoras(Asignacion asignacion) {
        long nuevaHora = Duration.between(asignacion.getHoraInicio(),asignacion.getHoraFin()).toHours();

        List<Asignacion> asignaciones = ServiceLocator.getInstanceAsignacionDAO().buscarUnidadesYHoras(asignacion.getIdunidad().getId(), asignacion.getTipoHora());
        long horasAcumuladas = 0;

        for(Asignacion a : asignaciones) {
            horasAcumuladas += Duration.between(a.getHoraInicio(), a.getHoraFin()).toHours();
        }
        long total = horasAcumuladas + nuevaHora;

        switch(asignacion.getTipoHora()) {
            case CLASE:
                if(total > asignacion.getIdunidad().getHorasClase()){
                    throw new IllegalArgumentException("No se pueden asignar mas horas de clase");
                }
                break;
            case LABORATORIO:
                if(total > asignacion.getIdunidad().getHorasLaboratorio()){
                    throw new IllegalArgumentException("No se pueden asignar mas horas de Laboratorio");
                }
                break;
            case TALLER:
                if(total > asignacion.getIdunidad().getHorasTaller()){
                    throw new IllegalArgumentException("No se pueden asignar mas horas de Taller");
                }
                break;
        }
    }
    private void validarTraslape(Asignacion asignacion) {
        List<Asignacion> asignaciones = ServiceLocator.getInstanceAsignacionDAO().buscarProfesorYDia(asignacion.getIdprofesor().getId(), asignacion.getDia());

        for(Asignacion a : asignaciones) {
            boolean traslape = asignacion.getHoraInicio().isBefore(a.getHoraFin())
                    && asignacion.getHoraFin().isAfter(a.getHoraInicio());
        if(traslape) {
            throw new IllegalArgumentException("El profesor ya tiene un horario asignado ese dia entre esas horas");
        }
        }

    }
    private void validarVacios(Asignacion asignacion) {
        if (asignacion == null) {
            throw new IllegalArgumentException("Asignacion no puede ser nulo");
        }
        if (asignacion.getTipoHora() == null){
            throw new IllegalArgumentException("Tipo de hora no puede ser nulo");
        }
        if (asignacion.getDia() == null){
            throw new IllegalArgumentException("Dia no puede ser nulo");
        }
        if (asignacion.getHoraFin() == null){
            throw new IllegalArgumentException("Hora Fin no puede ser nulo");
        }
        if (asignacion.getHoraInicio() == null){
            throw new IllegalArgumentException("Hora Inicio no puede ser nulo");
        }
        if (asignacion.getIdprofesor() == null){
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }
        if (asignacion.getIdunidad() == null){
            throw new IllegalArgumentException("La unidad no puede ser nula");
        }
    }
    public List<Profesores> getProfesores(){
        return ServiceLocator.getInstanceAsignacionDAO().obtenerTodosProfesores();
    }
    public List<UnidadAprendizaje> getUnidades(){
        return ServiceLocator.getInstanceAsignacionDAO().obtenerTodosUnidades();
    }
    private void validarRangos(Asignacion asignacion) {
        if(!asignacion.getHoraInicio().isBefore(asignacion.getHoraFin())){
            throw new IllegalArgumentException("La hora inicio debe ser menor a la hora de fin");
        }
        LocalTime minimo = LocalTime.of(7,0);
        LocalTime maximo = LocalTime.of(21,0);
        if (asignacion.getHoraInicio().isBefore(minimo) || asignacion.getHoraInicio().isAfter(maximo)){
            throw new IllegalArgumentException("La hora de inicio debe ser entre 7:00 a 21:00");
        }
        if (asignacion.getHoraFin().isBefore(minimo) || asignacion.getHoraFin().isAfter(maximo)){
            throw new IllegalArgumentException("La hora de fin debe ser entre 7:00 a 21:00");
        }

    }
}
