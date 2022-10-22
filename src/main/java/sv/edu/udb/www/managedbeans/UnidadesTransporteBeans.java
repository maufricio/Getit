package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.entities.UnidadesTransporteEntity;
import sv.edu.udb.www.models.UnidadesTransporteModels;

import java.util.List;
@ManagedBean
@RequestScoped
public class UnidadesTransporteBeans {
    private int idEstado=0;
    private int idAdministrador=0;
    private int idAdminTransportista=0;
    private int idEstadoUnidad=0;

    //Entidad
    private UnidadesTransporteEntity unidadesTransporteEntity;
    //Modelo
    private UnidadesTransporteModels modeloUnidadesTransporte = new UnidadesTransporteModels();

    //constructor
    public UnidadesTransporteBeans() {
        setUnidadesTransporteEntity(new UnidadesTransporteEntity());
    }

    //Lista de las unidades de transporte por id de sesion
    public List<UnidadesTransporteEntity> getUnidadesTransportesid() {
        return modeloUnidadesTransporte.listarUnidadesTransporteid();
    }


    //insertar unidad de transporte
    public String ingresarUnidadesTransporte() {
        if (modeloUnidadesTransporte.insertarUnidadTransporte(unidadesTransporteEntity, idEstadoUnidad, idAdminTransportista)!= 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Unidad de transporte no Agregada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Agregado", "Unidad de transporte Agregada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        //Limpiamos los campos de formulario
        unidadesTransporteEntity=null;

        return "AdminTransportista/UnidadesTransporteIdSesion";
    }

    //Obtener unidad de transporte
    public String seleccionarId(int motoristaId  ) {
        if (modeloUnidadesTransporte.obtenerUnidadTransporte(motoristaId) == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "No se pudo obtener motorista");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Obtenido", "Obtenido con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);
            unidadesTransporteEntity=modeloUnidadesTransporte.obtenerUnidadTransporte(motoristaId);
            idEstadoUnidad=unidadesTransporteEntity.getEstadosGeneralesByEstadoUnidad().getIdEstado();
        }
        return "AdminTransportista/UnidadesTransporteIdSesion";
    }

    //eliminar unidades de transporte
    public String eliminarUnidadTransporte( int idUnidadTransporte) {
        if (modeloUnidadesTransporte.eliminarUnidadTransporte(idUnidadTransporte) != 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Unidad de transporte no Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Eliminado", "Unidad de transporte Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        //Limpiamos los campos de formulario
        unidadesTransporteEntity=null;
        return "AdminTransportista/UnidadesTransporteIdSesion";
    }

    //Editar unidad de transporte
    public String editarUnidadTransporte( ){
        if(modeloUnidadesTransporte.modificarUnidadTransporte(unidadesTransporteEntity, idEstadoUnidad, idAdminTransportista)!= 1){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Unidad de transporte no Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Actualizado", "Unidad de transporte Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "AdminTransportista/UnidadesTransporteIdSesion";
    }

    //set y get
    public UnidadesTransporteEntity getUnidadesTransporteEntity() {
        return unidadesTransporteEntity;
    }
    public void setUnidadesTransporteEntity(UnidadesTransporteEntity unidadesTransporteEntity) {
        this.unidadesTransporteEntity = unidadesTransporteEntity;
    }

    //set y get parametros de formulario UnidadesTransporteIdSesion
    public int getIdEstadoUnidad() {
        return idEstadoUnidad;
    }

    public void setIdEstadoUnidad(int idEstadoUnidad) {
        this.idEstadoUnidad = idEstadoUnidad;
    }

    public int getIdAdminTransportista() {
        return idAdminTransportista;
    }

    public void setIdAdminTransportista(int idAdminTransportista) {
        this.idAdminTransportista = idAdminTransportista;
    }


}
