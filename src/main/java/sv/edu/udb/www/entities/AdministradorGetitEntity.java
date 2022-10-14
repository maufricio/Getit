package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "administrador_getit", schema = "getit")
public class AdministradorGetitEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_administrador_getit", nullable = false)
    private int idAdministradorGetit;
    @Basic
    @Column(name = "nombreAdmin", nullable = false, length = 20)
    private String nombreAdmin;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "ganancias_getit", nullable = false, precision = 0)
    private double gananciasGetit;
    @OneToMany(mappedBy = "administradorGetitByIdAdministrador")
    private Collection<PedidosEntity> pedidosByIdAdministradorGetit;
    @OneToMany(mappedBy = "administradorGetitByAdminGetit")
    private Collection<UsuariosEntity> usuariosByIdAdministradorGetit;

    public int getIdAdministradorGetit() {
        return idAdministradorGetit;
    }

    public void setIdAdministradorGetit(int idAdministradorGetit) {
        this.idAdministradorGetit = idAdministradorGetit;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGananciasGetit() {
        return gananciasGetit;
    }

    public void setGananciasGetit(double gananciasGetit) {
        this.gananciasGetit = gananciasGetit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministradorGetitEntity that = (AdministradorGetitEntity) o;

        if (idAdministradorGetit != that.idAdministradorGetit) return false;
        if (Double.compare(that.gananciasGetit, gananciasGetit) != 0) return false;
        if (nombreAdmin != null ? !nombreAdmin.equals(that.nombreAdmin) : that.nombreAdmin != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAdministradorGetit;
        result = 31 * result + (nombreAdmin != null ? nombreAdmin.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(gananciasGetit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Collection<PedidosEntity> getPedidosByIdAdministradorGetit() {
        return pedidosByIdAdministradorGetit;
    }

    public void setPedidosByIdAdministradorGetit(Collection<PedidosEntity> pedidosByIdAdministradorGetit) {
        this.pedidosByIdAdministradorGetit = pedidosByIdAdministradorGetit;
    }

    public Collection<UsuariosEntity> getUsuariosByIdAdministradorGetit() {
        return usuariosByIdAdministradorGetit;
    }

    public void setUsuariosByIdAdministradorGetit(Collection<UsuariosEntity> usuariosByIdAdministradorGetit) {
        this.usuariosByIdAdministradorGetit = usuariosByIdAdministradorGetit;
    }
}
