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

    @Lob
    @Column(name = "dia")
    private String dia;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Lob
    @Column(name = "tipo_hora")
    private String tipoHora;

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
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

    public String getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(String tipoHora) {
        this.tipoHora = tipoHora;
    }

}