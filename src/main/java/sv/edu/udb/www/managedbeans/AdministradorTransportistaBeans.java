package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import sv.edu.udb.www.entities.AdministradorTransportistaEntity;
import sv.edu.udb.www.models.AdministradorTransportistaModels;

import java.util.List;

@ManagedBean
@RequestScoped
public class AdministradorTransportistaBeans {
    private AdministradorTransportistaEntity administradorTransportistaEntity;

    private AdministradorTransportistaModels modelo = new AdministradorTransportistaModels();
    public AdministradorTransportistaBeans() {
        administradorTransportistaEntity = new AdministradorTransportistaEntity();
    }
    public List<AdministradorTransportistaEntity> getAdministradorTransportistas() {
        return modelo.listarEntrada();
    }


    public AdministradorTransportistaEntity getAdministradorTransportistaEntity() {
        return administradorTransportistaEntity;
    }

    public void setAdministradorTransportistaEntity(AdministradorTransportistaEntity administradorTransportistaEntity) {
        this.administradorTransportistaEntity = administradorTransportistaEntity;
    }
}
