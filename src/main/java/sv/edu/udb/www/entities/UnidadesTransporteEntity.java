package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "unidades_transporte", schema = "getit")
public class UnidadesTransporteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_unidadTransporte", nullable = false)
    private int idUnidadTransporte;
    @Basic
    @Column(name = "placa", nullable = false, length = 20)
    private String placa;
    @Basic
    @Column(name = "tipoVehiculo", nullable = false)
    private String tipoVehiculo;
    @Basic
    @Column(name = "pesoVehiculo", nullable = false)
    private String pesoVehiculo;
    @OneToMany(mappedBy = "unidadesTransporteByIdUnidadTransporte")
    private Collection<PedidosEntity> pedidosByIdUnidadTransporte;
    @ManyToOne
    @JoinColumn(name = "Id_administrador_transportista", referencedColumnName = "Id_administrador_transportista", nullable = false)
    private AdministradorTransportistaEntity administradorTransportistaByIdAdministradorTransportista;
    @ManyToOne
    @JoinColumn(name = "estado_unidad", referencedColumnName = "Id_estado", nullable = false)
    private EstadosGeneralesEntity estadosGeneralesByEstadoUnidad;

    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPesoVehiculo() {
        return pesoVehiculo;
    }

    public void setPesoVehiculo(String pesoVehiculo) {
        this.pesoVehiculo = pesoVehiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnidadesTransporteEntity that = (UnidadesTransporteEntity) o;

        if (idUnidadTransporte != that.idUnidadTransporte) return false;
        if (placa != null ? !placa.equals(that.placa) : that.placa != null) return false;
        if (tipoVehiculo != null ? !tipoVehiculo.equals(that.tipoVehiculo) : that.tipoVehiculo != null) return false;
        if (pesoVehiculo != null ? !pesoVehiculo.equals(that.pesoVehiculo) : that.pesoVehiculo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUnidadTransporte;
        result = 31 * result + (placa != null ? placa.hashCode() : 0);
        result = 31 * result + (tipoVehiculo != null ? tipoVehiculo.hashCode() : 0);
        result = 31 * result + (pesoVehiculo != null ? pesoVehiculo.hashCode() : 0);
        return result;
    }

    public Collection<PedidosEntity> getPedidosByIdUnidadTransporte() {
        return pedidosByIdUnidadTransporte;
    }

    public void setPedidosByIdUnidadTransporte(Collection<PedidosEntity> pedidosByIdUnidadTransporte) {
        this.pedidosByIdUnidadTransporte = pedidosByIdUnidadTransporte;
    }

    public AdministradorTransportistaEntity getAdministradorTransportistaByIdAdministradorTransportista() {
        return administradorTransportistaByIdAdministradorTransportista;
    }

    public void setAdministradorTransportistaByIdAdministradorTransportista(AdministradorTransportistaEntity administradorTransportistaByIdAdministradorTransportista) {
        this.administradorTransportistaByIdAdministradorTransportista = administradorTransportistaByIdAdministradorTransportista;
    }

    public EstadosGeneralesEntity getEstadosGeneralesByEstadoUnidad() {
        return estadosGeneralesByEstadoUnidad;
    }

    public void setEstadosGeneralesByEstadoUnidad(EstadosGeneralesEntity estadosGeneralesByEstadoUnidad) {
        this.estadosGeneralesByEstadoUnidad = estadosGeneralesByEstadoUnidad;
    }
}
