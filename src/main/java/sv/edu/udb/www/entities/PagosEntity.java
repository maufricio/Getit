package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "pagos", schema = "getit")
public class PagosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "monto_pago", nullable = false, precision = 0)
    private double montoPago;

    @ManyToOne
    @JoinColumn(name = "Id_comida", referencedColumnName = "Id_comida", nullable = false)
    private ComidasEntity comidasByIdComida;
    @ManyToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente", nullable = false)
    private ClientesEntity clientesByIdCliente;
    @ManyToOne
    @JoinColumn(name = "tipo_pago", referencedColumnName = "Id_tipoPago", nullable = false)
    private TipoPagosEntity tipoPagosByTipoPago;
    @OneToMany(mappedBy = "pagosByIdPago")
    private Collection<PedidosEntity> pedidosByIdPago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagosEntity that = (PagosEntity) o;

        if (idPago != that.idPago) return false;
        if (Double.compare(that.montoPago, montoPago) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPago;
        temp = Double.doubleToLongBits(montoPago);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public ComidasEntity getComidasByIdComida() {
        return comidasByIdComida;
    }

    public void setComidasByIdComida(ComidasEntity comidasByIdComida) {
        this.comidasByIdComida = comidasByIdComida;
    }

    public ClientesEntity getClientesByIdCliente() {
        return clientesByIdCliente;
    }

    public void setClientesByIdCliente(ClientesEntity clientesByIdCliente) {
        this.clientesByIdCliente = clientesByIdCliente;
    }

    public TipoPagosEntity getTipoPagosByTipoPago() {
        return tipoPagosByTipoPago;
    }

    public void setTipoPagosByTipoPago(TipoPagosEntity tipoPagosByTipoPago) {
        this.tipoPagosByTipoPago = tipoPagosByTipoPago;
    }

    public Collection<PedidosEntity> getPedidosByIdPago() {
        return pedidosByIdPago;
    }

    public void setPedidosByIdPago(Collection<PedidosEntity> pedidosByIdPago) {
        this.pedidosByIdPago = pedidosByIdPago;
    }
}
