package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedidos", schema = "getit", catalog = "")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_pedido", nullable = false)
    private int idPedido;
    @Basic
    @Column(name = "Id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "Id_motorista", nullable = false)
    private int idMotorista;
    @Basic
    @Column(name = "Id_unidadTransporte", nullable = false)
    private int idUnidadTransporte;
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
    @Column(name = "estado_pedido", nullable = false)
    private int estadoPedido;
    @Basic
    @Column(name = "fecha_efectuacion", nullable = false)
    private Date fechaEfectuacion;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
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

    public int getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(int estadoPedido) {
        this.estadoPedido = estadoPedido;
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
        if (idPago != that.idPago) return false;
        if (idMotorista != that.idMotorista) return false;
        if (idUnidadTransporte != that.idUnidadTransporte) return false;
        if (idAdministrador != that.idAdministrador) return false;
        if (estadoPedido != that.estadoPedido) return false;
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
        result = 31 * result + idPago;
        result = 31 * result + idMotorista;
        result = 31 * result + idUnidadTransporte;
        result = 31 * result + idAdministrador;
        result = 31 * result + (direccionDomicilio != null ? direccionDomicilio.hashCode() : 0);
        result = 31 * result + (tiempoTardado != null ? tiempoTardado.hashCode() : 0);
        result = 31 * result + estadoPedido;
        result = 31 * result + (fechaEfectuacion != null ? fechaEfectuacion.hashCode() : 0);
        return result;
    }
}
