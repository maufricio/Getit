package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "getit")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_usuario", nullable = false)
    private int idUsuario;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "Id_cliente")
    private ClientesEntity clientesByUsuario;
    @ManyToOne
    @JoinColumn(name = "admin_getit", referencedColumnName = "Id_administrador_getit")
    private AdministradorGetitEntity administradorGetitByAdminGetit;
    @ManyToOne
    @JoinColumn(name = "admin_transporte", referencedColumnName = "Id_administrador_transportista")
    private AdministradorTransportistaEntity administradorTransportistaByAdminTransporte;
    @ManyToOne
    @JoinColumn(name = "motorista", referencedColumnName = "Id_motorista")
    private MotoristaEntity motoristaByMotorista;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idUsuario != that.idUsuario) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUsuario;
    }

    public ClientesEntity getClientesByUsuario() {
        return clientesByUsuario;
    }

    public void setClientesByUsuario(ClientesEntity clientesByUsuario) {
        this.clientesByUsuario = clientesByUsuario;
    }

    public AdministradorGetitEntity getAdministradorGetitByAdminGetit() {
        return administradorGetitByAdminGetit;
    }

    public void setAdministradorGetitByAdminGetit(AdministradorGetitEntity administradorGetitByAdminGetit) {
        this.administradorGetitByAdminGetit = administradorGetitByAdminGetit;
    }

    public AdministradorTransportistaEntity getAdministradorTransportistaByAdminTransporte() {
        return administradorTransportistaByAdminTransporte;
    }

    public void setAdministradorTransportistaByAdminTransporte(AdministradorTransportistaEntity administradorTransportistaByAdminTransporte) {
        this.administradorTransportistaByAdminTransporte = administradorTransportistaByAdminTransporte;
    }

    public MotoristaEntity getMotoristaByMotorista() {
        return motoristaByMotorista;
    }

    public void setMotoristaByMotorista(MotoristaEntity motoristaByMotorista) {
        this.motoristaByMotorista = motoristaByMotorista;
    }
}
