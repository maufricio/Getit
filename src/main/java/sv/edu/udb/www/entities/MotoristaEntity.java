package sv.edu.udb.www.entities;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "motorista", schema = "getit")
@NamedQueries({
        @NamedQuery(name = "Motorista.findAllComidas", query = "SELECT OBJECT(com) FROM ComidasEntity com")
})
public class MotoristaEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_motorista", nullable = false)
    private int idMotorista;
    @Basic
    @Column(name = "DUI", nullable = false, length = 10)
    private String dui;
    @Basic
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNac;
    @Basic
    @Column(name = "Id_administrador_transportista", nullable = false)
    private int idAdministradorTransportista;
    @Basic
    @Column(name = "estado_motorista", nullable = false)
    private int estadoMotorista;

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getIdAdministradorTransportista() {
        return idAdministradorTransportista;
    }

    public void setIdAdministradorTransportista(int idAdministradorTransportista) {
        this.idAdministradorTransportista = idAdministradorTransportista;
    }

    public int getEstadoMotorista() {
        return estadoMotorista;
    }

    public void setEstadoMotorista(int estadoMotorista) {
        this.estadoMotorista = estadoMotorista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MotoristaEntity that = (MotoristaEntity) o;

        if (idMotorista != that.idMotorista) return false;
        if (idAdministradorTransportista != that.idAdministradorTransportista) return false;
        if (estadoMotorista != that.estadoMotorista) return false;
        if (dui != null ? !dui.equals(that.dui) : that.dui != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fechaNac != null ? !fechaNac.equals(that.fechaNac) : that.fechaNac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMotorista;
        result = 31 * result + (dui != null ? dui.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        result = 31 * result + idAdministradorTransportista;
        result = 31 * result + estadoMotorista;
        return result;
    }
}
