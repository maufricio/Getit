package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "motorista", schema = "getit")
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
    @ManyToOne
    @JoinColumn(name = "Id_administrador_transportista", referencedColumnName = "Id_administrador_transportista", nullable = false)
    private AdministradorTransportistaEntity administradorTransportistaByIdAdministradorTransportista;
    @ManyToOne
    @JoinColumn(name = "estado_motorista", referencedColumnName = "Id_estado", nullable = false)
    private EstadosGeneralesEntity estadosGeneralesByEstadoMotorista;
    @OneToMany(mappedBy = "motoristaByIdMotorista")
    private Collection<PedidosEntity> pedidosByIdMotorista;
    @OneToMany(mappedBy = "motoristaByMotorista")
    private Collection<UsuariosEntity> usuariosByIdMotorista;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MotoristaEntity that = (MotoristaEntity) o;

        if (idMotorista != that.idMotorista) return false;
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
        return result;
    }

    public AdministradorTransportistaEntity getAdministradorTransportistaByIdAdministradorTransportista() {
        return administradorTransportistaByIdAdministradorTransportista;
    }

    public void setAdministradorTransportistaByIdAdministradorTransportista(AdministradorTransportistaEntity administradorTransportistaByIdAdministradorTransportista) {
        this.administradorTransportistaByIdAdministradorTransportista = administradorTransportistaByIdAdministradorTransportista;
    }

    public EstadosGeneralesEntity getEstadosGeneralesByEstadoMotorista() {
        return estadosGeneralesByEstadoMotorista;
    }

    public void setEstadosGeneralesByEstadoMotorista(EstadosGeneralesEntity estadosGeneralesByEstadoMotorista) {
        this.estadosGeneralesByEstadoMotorista = estadosGeneralesByEstadoMotorista;
    }

    public Collection<PedidosEntity> getPedidosByIdMotorista() {
        return pedidosByIdMotorista;
    }

    public void setPedidosByIdMotorista(Collection<PedidosEntity> pedidosByIdMotorista) {
        this.pedidosByIdMotorista = pedidosByIdMotorista;
    }

    public Collection<UsuariosEntity> getUsuariosByIdMotorista() {
        return usuariosByIdMotorista;
    }

    public void setUsuariosByIdMotorista(Collection<UsuariosEntity> usuariosByIdMotorista) {
        this.usuariosByIdMotorista = usuariosByIdMotorista;
    }
}
