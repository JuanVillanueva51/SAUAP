package ui;

import helper.asignarUnidadesHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.sauap.entity.Asignacion;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.entity.UnidadAprendizaje;
import mx.desarrollo.sauap.negocio.integration.ServiceFacadeLocator;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Named("asignarUnidadesUI")
@SessionScoped
public class asignarUnidadesBeanUI implements Serializable {
    private asignarUnidadesHelper asignarHelper;
    private Asignacion asignacion;
    private String horaInicio;
    private String horaFin;
    private List<Profesores> profesores;
    private List<UnidadAprendizaje> unidades;
    private Integer idUnidadSeleccionada;
    private Integer idProfesorSeleccionado;

    public asignarUnidadesBeanUI() {
        asignarHelper = new asignarUnidadesHelper();
    }

@PostConstruct
    public void init() {
        asignacion = new Asignacion();
        profesores = ServiceFacadeLocator.getInstanceAsignacionFacade().getProfesores();
        unidades = ServiceFacadeLocator.getInstanceAsignacionFacade().getUnidades();
    }

    public List<String> getHorasDisponibles(){
        List<String> horas = new ArrayList<>();
        LocalTime horaInicial = LocalTime.of(7, 0);
        LocalTime limite = LocalTime.of(21, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (!horaInicial.isAfter(limite)) {
            horas.add(horaInicial.format(formatter));
            horaInicial = horaInicial.plusHours(1);
        }
        return horas;
    }
    public void asignarUnidades() {
        try{
            asignacion.setHoraInicio(LocalTime.parse(horaInicio));
            asignacion.setHoraFin(LocalTime.parse(horaFin));
            for (Profesores prof : profesores) {
                if (prof.getId().equals(idProfesorSeleccionado)) {
                    asignacion.setIdprofesor(prof);
                    break;
                }
            }

            for (UnidadAprendizaje uni : unidades) {
                if (uni.getId().equals(idUnidadSeleccionada)) {
                    asignacion.setIdunidad(uni);
                    break;
                }
            }
            asignarHelper.asignarUnidades(asignacion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito", "La asignacion se completo correctamente"));
            asignacion = new Asignacion();
            horaInicio = null;
            horaFin = null;
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "ERROR", e.getMessage()));
        }
    }
    public Asignacion.Dia[] getDias(){
        return Asignacion.Dia.values();
    }
    public Asignacion.TipoHora[] getTipoHora(){
        return Asignacion.TipoHora.values();
    }
    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public String getHoraInicioSeleccionada() {
        return horaInicio;
    }

    public void setHoraInicioSeleccionada(String horaInicioSeleccionada) {
        this.horaInicio = horaInicioSeleccionada;
    }

    public String getHoraFinSeleccionada() {
        return horaFin;
    }

    public void setHoraFinSeleccionada(String horaFinSeleccionada) {
        this.horaFin = horaFinSeleccionada;
    }

    public List<Profesores> getProfesores(){
        return profesores;
    }
    public List<UnidadAprendizaje> getUnidades(){
        return unidades;
    }
    public Integer getIdProfesorSeleccionado() {
        return idProfesorSeleccionado;
    }

    public void setIdProfesorSeleccionado(Integer idProfesorSeleccionado) {
        this.idProfesorSeleccionado = idProfesorSeleccionado;
    }

    public Integer getIdUnidadSeleccionada() {
        return idUnidadSeleccionada;
    }

    public void setIdUnidadSeleccionada(Integer idUnidadSeleccionada) {
        this.idUnidadSeleccionada = idUnidadSeleccionada;
    }
}

