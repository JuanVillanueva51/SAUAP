package mx.desarrollo.sauap.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "profesores")
public class Profesore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofesores", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Size(max = 50)
    @Column(name = "apellido_paterno", length = 50)
    private String apellidoPaterno;

    @Size(max = 50)
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;

    @Size(max = 13)
    @Column(name = "RFC", length = 13)
    private String rfc;

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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

}