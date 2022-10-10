package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_pedido", schema = "getit", catalog = "")
public class EstadosPedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_estado", nullable = false)
    private int idEstado;
    @Basic
    @Column(name = "nombreEstado", nullable = false, length = 50)
    private String nombreEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadosPedidoEntity that = (EstadosPedidoEntity) o;

        if (idEstado != that.idEstado) return false;
        if (nombreEstado != null ? !nombreEstado.equals(that.nombreEstado) : that.nombreEstado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstado;
        result = 31 * result + (nombreEstado != null ? nombreEstado.hashCode() : 0);
        return result;
    }
}
