package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedidos", schema = "getit")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_pedido", nullable = false)
    private int idPedido;
    @Basic
    @Column(name = "Id_administrador", nullable = false)
    private int idAdministrador;
    @Basic
    @Column(name = "direccion_domicilio", nullable = false, length = 50)
    private String direccionDomicilio;
    @Basic
    @Column(name = "tiempo_tardado", nullable = false, length = 30)
    private String tiempoTardado;
    @Basic
    @Column(name = "fecha_efectuacion", nullable = false)
    private Date fechaEfectuacion;


    @ManyToOne
    @JoinColumn(name = "Id_pago", referencedColumnName = "Id_pago", nullable = false)
    private PagosEntity pagosByIdPago;
    @ManyToOne
    @JoinColumn(name = "Id_motorista", referencedColumnName = "Id_motorista", nullable = false)
    private MotoristaEntity motoristaByIdMotorista;
    @ManyToOne
    @JoinColumn(name = "Id_unidadTransporte", referencedColumnName = "Id_unidadTransporte", nullable = false)
    private UnidadesTransporteEntity unidadesTransporteByIdUnidadTransporte;
    @ManyToOne
    @JoinColumn(name = "Id_administrador", referencedColumnName = "Id_administrador_getit", nullable = false, updatable = false, insertable = false)
    private AdministradorGetitEntity administradorGetitByIdAdministrador;
    @ManyToOne
    @JoinColumn(name = "estado_pedido", referencedColumnName = "Id_estado", nullable = false)
    private EstadosPedidoEntity estadosPedidoByEstadoPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getTiempoTardado() {
        return tiempoTardado;
    }

    public void setTiempoTardado(String tiempoTardado) {
        this.tiempoTardado = tiempoTardado;
    }

    public Date getFechaEfectuacion() {
        return fechaEfectuacion;
    }

    public void setFechaEfectuacion(Date fechaEfectuacion) {
        this.fechaEfectuacion = fechaEfectuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidosEntity that = (PedidosEntity) o;

        if (idPedido != that.idPedido) return false;
        if (idAdministrador != that.idAdministrador) return false;
        if (direccionDomicilio != null ? !direccionDomicilio.equals(that.direccionDomicilio) : that.direccionDomicilio != null)
            return false;
        if (tiempoTardado != null ? !tiempoTardado.equals(that.tiempoTardado) : that.tiempoTardado != null)
            return false;
        if (fechaEfectuacion != null ? !fechaEfectuacion.equals(that.fechaEfectuacion) : that.fechaEfectuacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido;
        result = 31 * result + idAdministrador;
        result = 31 * result + (direccionDomicilio != null ? direccionDomicilio.hashCode() : 0);
        result = 31 * result + (tiempoTardado != null ? tiempoTardado.hashCode() : 0);
        result = 31 * result + (fechaEfectuacion != null ? fechaEfectuacion.hashCode() : 0);
        return result;
    }

    public PagosEntity getPagosByIdPago() {
        return pagosByIdPago;
    }

    public void setPagosByIdPago(PagosEntity pagosByIdPago) {
        this.pagosByIdPago = pagosByIdPago;
    }

    public MotoristaEntity getMotoristaByIdMotorista() {
        return motoristaByIdMotorista;
    }

    public void setMotoristaByIdMotorista(MotoristaEntity motoristaByIdMotorista) {
        this.motoristaByIdMotorista = motoristaByIdMotorista;
    }

    public UnidadesTransporteEntity getUnidadesTransporteByIdUnidadTransporte() {
        return unidadesTransporteByIdUnidadTransporte;
    }

    public void setUnidadesTransporteByIdUnidadTransporte(UnidadesTransporteEntity unidadesTransporteByIdUnidadTransporte) {
        this.unidadesTransporteByIdUnidadTransporte = unidadesTransporteByIdUnidadTransporte;
    }

    public AdministradorGetitEntity getAdministradorGetitByIdAdministrador() {
        return administradorGetitByIdAdministrador;
    }

    public void setAdministradorGetitByIdAdministrador(AdministradorGetitEntity administradorGetitByIdAdministrador) {
        this.administradorGetitByIdAdministrador = administradorGetitByIdAdministrador;
    }

    public EstadosPedidoEntity getEstadosPedidoByEstadoPedido() {
        return estadosPedidoByEstadoPedido;
    }

    public void setEstadosPedidoByEstadoPedido(EstadosPedidoEntity estadosPedidoByEstadoPedido) {
        this.estadosPedidoByEstadoPedido = estadosPedidoByEstadoPedido;
    }
}
