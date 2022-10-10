package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos", schema = "getit", catalog = "")
public class PagosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "Id_comida", nullable = false)
    private int idComida;
    @Basic
    @Column(name = "Id_cliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "monto_pago", nullable = false, precision = 0)
    private double montoPago;
    @Basic
    @Column(name = "tipo_pago", nullable = false)
    private int tipoPago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagosEntity that = (PagosEntity) o;

        if (idPago != that.idPago) return false;
        if (idComida != that.idComida) return false;
        if (idCliente != that.idCliente) return false;
        if (Double.compare(that.montoPago, montoPago) != 0) return false;
        if (tipoPago != that.tipoPago) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPago;
        result = 31 * result + idComida;
        result = 31 * result + idCliente;
        temp = Double.doubleToLongBits(montoPago);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + tipoPago;
        return result;
    }
}
