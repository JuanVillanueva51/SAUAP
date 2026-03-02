package mx.desarrollo.sauap.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "unidad_aprendizaje")
public class UnidadAprendizaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunidad_aprendizaje", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "horas_clase")
    private Byte horasClase;

    @Column(name = "horas_taller")
    private Byte horasTaller;

    @Column(name = "horas_laboratorio")
    private Byte horasLaboratorio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Byte horasClase) {
        this.horasClase = horasClase;
    }

    public Byte getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Byte horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Byte getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Byte horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

}