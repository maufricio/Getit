package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "estados_generales", schema = "getit")
public class EstadosGeneralesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_estado", nullable = false)
    private int idEstado;
    @Basic
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
    @OneToMany(mappedBy = "estadosGeneralesByEstadoMotorista")
    private Collection<MotoristaEntity> motoristasByIdEstado;
    @OneToMany(mappedBy = "estadosGeneralesByEstadoUnidad")
    private Collection<UnidadesTransporteEntity> unidadesTransportesByIdEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadosGeneralesEntity that = (EstadosGeneralesEntity) o;

        if (idEstado != that.idEstado) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstado;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<MotoristaEntity> getMotoristasByIdEstado() {
        return motoristasByIdEstado;
    }

    public void setMotoristasByIdEstado(Collection<MotoristaEntity> motoristasByIdEstado) {
        this.motoristasByIdEstado = motoristasByIdEstado;
    }

    public Collection<UnidadesTransporteEntity> getUnidadesTransportesByIdEstado() {
        return unidadesTransportesByIdEstado;
    }

    public void setUnidadesTransportesByIdEstado(Collection<UnidadesTransporteEntity> unidadesTransportesByIdEstado) {
        this.unidadesTransportesByIdEstado = unidadesTransportesByIdEstado;
    }
}
