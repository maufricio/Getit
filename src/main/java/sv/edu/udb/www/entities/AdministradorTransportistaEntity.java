package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador_transportista", schema = "getit", catalog = "")
public class AdministradorTransportistaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_administrador_transportista", nullable = false)
    private int idAdministradorTransportista;
    @Basic
    @Column(name = "nombreEmpresa", nullable = false, length = 50)
    private String nombreEmpresa;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "ganancias_transporte", nullable = false, precision = 0)
    private double gananciasTransporte;

    public int getIdAdministradorTransportista() {
        return idAdministradorTransportista;
    }

    public void setIdAdministradorTransportista(int idAdministradorTransportista) {
        this.idAdministradorTransportista = idAdministradorTransportista;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGananciasTransporte() {
        return gananciasTransporte;
    }

    public void setGananciasTransporte(double gananciasTransporte) {
        this.gananciasTransporte = gananciasTransporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministradorTransportistaEntity that = (AdministradorTransportistaEntity) o;

        if (idAdministradorTransportista != that.idAdministradorTransportista) return false;
        if (Double.compare(that.gananciasTransporte, gananciasTransporte) != 0) return false;
        if (nombreEmpresa != null ? !nombreEmpresa.equals(that.nombreEmpresa) : that.nombreEmpresa != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAdministradorTransportista;
        result = 31 * result + (nombreEmpresa != null ? nombreEmpresa.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(gananciasTransporte);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
