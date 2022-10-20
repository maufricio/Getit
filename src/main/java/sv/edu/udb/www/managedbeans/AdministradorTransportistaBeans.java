package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.AdministradorTransportistaEntity;
import sv.edu.udb.www.models.AdministradorTransportistaModel;

import java.util.List;

@ManagedBean
@RequestScoped
//Alex Villalta
public class AdministradorTransportistaBeans {
    //Entidad
    private AdministradorTransportistaEntity administradorTransportistaEntity;
    //Modelo Administrador transportista
    private AdministradorTransportistaModel modelo = new AdministradorTransportistaModel();
    //Constructor
    public AdministradorTransportistaBeans() {
        setAdministradorTransportistaEntity(new AdministradorTransportistaEntity());
    }

    //Listar empresa por id de sesion
    public List<AdministradorTransportistaEntity> getAdministradorTransportistasid() {
        return modelo.listarAdministradorTransportistaid();
    }

    //lista empresas
    public List<AdministradorTransportistaEntity> getAdministradorTransportistas() {
       return  modelo.listarEmpresas();

    }

    //set y get
    public AdministradorTransportistaEntity getAdministradorTransportistaEntity() {
        return administradorTransportistaEntity;
    }

    public void setAdministradorTransportistaEntity(AdministradorTransportistaEntity administradorTransportistaEntity) {
        this.administradorTransportistaEntity = administradorTransportistaEntity;
    }



}
