package mx.desarrollo.sauap.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignacion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idunidad", nullable = false)
    private UnidadAprendizaje idunidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofesor")
    private Profesores idprofesor;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia", nullable = false)
    private Dia dia;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_hora", nullable = false)
    private TipoHora tipoHora;

    public enum Dia {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO
    }

    public enum TipoHora {
        CLASE,
        TALLER,
        LABORATORIO
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Dia getDia() {return dia;}

    public void setDia(Dia dia) {
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