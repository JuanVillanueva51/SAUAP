package mx.desarrollo.sauap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AsignacionId implements Serializable {
    private static final long serialVersionUID = -3498762275855597035L;
    @NotNull
    @Column(name = "idasignacion", nullable = false)
    private Integer idasignacion;

    @NotNull
    @Column(name = "idunidad", nullable = false)
    private Integer idunidad;

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignacionId entity = (AsignacionId) o;
        return Objects.equals(this.idasignacion, entity.idasignacion) &&
                Objects.equals(this.idunidad, entity.idunidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idasignacion, idunidad);
    }
}