package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quejas", schema = "getit", catalog = "")
public class QuejasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_queja", nullable = false)
    private int idQueja;
    @Basic
    @Column(name = "Id_idUsuario", nullable = false)
    private int idIdUsuario;
    @Basic
    @Column(name = "descripcionQueja", nullable = false, length = -1)
    private String descripcionQueja;
    @Basic
    @Column(name = "respuestaQueja", nullable = false, length = -1)
    private String respuestaQueja;

    public int getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(int idQueja) {
        this.idQueja = idQueja;
    }

    public int getIdIdUsuario() {
        return idIdUsuario;
    }

    public void setIdIdUsuario(int idIdUsuario) {
        this.idIdUsuario = idIdUsuario;
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
        if (idIdUsuario != that.idIdUsuario) return false;
        if (descripcionQueja != null ? !descripcionQueja.equals(that.descripcionQueja) : that.descripcionQueja != null)
            return false;
        if (respuestaQueja != null ? !respuestaQueja.equals(that.respuestaQueja) : that.respuestaQueja != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQueja;
        result = 31 * result + idIdUsuario;
        result = 31 * result + (descripcionQueja != null ? descripcionQueja.hashCode() : 0);
        result = 31 * result + (respuestaQueja != null ? respuestaQueja.hashCode() : 0);
        return result;
    }
}
