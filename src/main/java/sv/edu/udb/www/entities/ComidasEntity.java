package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "comidas", schema = "getit")
public class ComidasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_comida", nullable = false)
    private int idComida;
    @Basic
    @Column(name = "imagen_comida", nullable = false)
    private byte[] imagenComida;
    @Basic
    @Column(name = "nombre_comida", nullable = false, length = 100)
    private String nombreComida;
    @Basic
    @Column(name = "tipo_oferta_comida", nullable = false)
    private String tipoOfertaComida;
    @Basic
    @Column(name = "precio_comida", nullable = false, precision = 0)
    private double precioComida;
    @Basic
    @Column(name = "stock_comida", nullable = false)
    private int stockComida;

    @OneToMany(mappedBy = "comidasByIdComida")
    private Collection<PagosEntity> pagosByIdComida;

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public byte[] getImagenComida() {
        return imagenComida;
    }

    public void setImagenComida(byte[] imagenComida) {
        this.imagenComida = imagenComida;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public String getTipoOfertaComida() {
        return tipoOfertaComida;
    }

    public void setTipoOfertaComida(String tipoOfertaComida) {
        this.tipoOfertaComida = tipoOfertaComida;
    }

    public double getPrecioComida() {
        return precioComida;
    }

    public void setPrecioComida(double precioComida) {
        this.precioComida = precioComida;
    }

    public int getStockComida() {
        return stockComida;
    }

    public void setStockComida(int stockComida) {
        this.stockComida = stockComida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComidasEntity that = (ComidasEntity) o;

        if (idComida != that.idComida) return false;
        if (Double.compare(that.precioComida, precioComida) != 0) return false;
        if (stockComida != that.stockComida) return false;
        if (!Arrays.equals(imagenComida, that.imagenComida)) return false;
        if (nombreComida != null ? !nombreComida.equals(that.nombreComida) : that.nombreComida != null) return false;
        if (tipoOfertaComida != null ? !tipoOfertaComida.equals(that.tipoOfertaComida) : that.tipoOfertaComida != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idComida;
        result = 31 * result + Arrays.hashCode(imagenComida);
        result = 31 * result + (nombreComida != null ? nombreComida.hashCode() : 0);
        result = 31 * result + (tipoOfertaComida != null ? tipoOfertaComida.hashCode() : 0);
        temp = Double.doubleToLongBits(precioComida);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + stockComida;
        return result;
    }

    public Collection<PagosEntity> getPagosByIdComida() {
        return pagosByIdComida;
    }

    public void setPagosByIdComida(Collection<PagosEntity> pagosByIdComida) {
        this.pagosByIdComida = pagosByIdComida;
    }
}
