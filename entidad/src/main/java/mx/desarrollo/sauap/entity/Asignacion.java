package mx.desarrollo.sauap.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "asignacion")
public class Asignacion {
    @EmbeddedId
    private AsignacionId id;

    @MapsId("idunidad")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idunidad", nullable = false)
    private UnidadAprendizaje idunidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofesor")
    private Profesores idprofesor;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia")
    private DiaSemana dia;
    public enum DiaSemana {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES
    }
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_hora")
    private TipoHora tipoHora;
    public enum TipoHora {
        CLASE,
        TALLER,
        LABORATORIO
    }

    public AsignacionId getId() {
        return id;
    }

    public void setId(AsignacionId id) {
        this.id = id;
    }

    public UnidadAprendizaje getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(UnidadAprendizaje idunidad) {
        this.idunidad = idunidad;
    }

    public Profesores getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesores idprofesor) {
        this.idprofesor = idprofesor;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public TipoHora getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(TipoHora tipoHora) {
        this.tipoHora = tipoHora;
    }

}