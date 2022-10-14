package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quejas", schema = "getit")
public class QuejasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_queja", nullable = false)
    private int idQueja;
    @Basic
    @Column(name = "descripcionQueja", nullable = false, length = -1)
    private String descripcionQueja;
    @Basic
    @Column(name = "respuestaQueja", nullable = false, length = -1)
    private String respuestaQueja;
    @ManyToOne
    @JoinColumn(name = "Id_idUsuario", referencedColumnName = "Id_cliente", nullable = false)
    private ClientesEntity clientesByIdIdUsuario;

    public int getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(int idQueja) {
        this.idQueja = idQueja;
    }

    public String getDescripcionQueja() {
        return descripcionQueja;
    }

    public void setDescripcionQueja(String descripcionQueja) {
        this.descripcionQueja = descripcionQueja;
    }

    public String getRespuestaQueja() {
        return respuestaQueja;
    }

    public void setRespuestaQueja(String respuestaQueja) {
        this.respuestaQueja = respuestaQueja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuejasEntity that = (QuejasEntity) o;

        if (idQueja != that.idQueja) return false;
        if (descripcionQueja != null ? !descripcionQueja.equals(that.descripcionQueja) : that.descripcionQueja != null)
            return false;
        if (respuestaQueja != null ? !respuestaQueja.equals(that.respuestaQueja) : that.respuestaQueja != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQueja;
        result = 31 * result + (descripcionQueja != null ? descripcionQueja.hashCode() : 0);
        result = 31 * result + (respuestaQueja != null ? respuestaQueja.hashCode() : 0);
        return result;
    }

    public ClientesEntity getClientesByIdIdUsuario() {
        return clientesByIdIdUsuario;
    }

    public void setClientesByIdIdUsuario(ClientesEntity clientesByIdIdUsuario) {
        this.clientesByIdIdUsuario = clientesByIdIdUsuario;
    }
}
