package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.models.MotoristaModels;

import java.util.List;

//Alex Villalta
@ManagedBean
@RequestScoped
public class AdminMotoristaBeans {
    //Entidad
    private MotoristaEntity motoristaEntity;
    //parametros
    private int idAdminTransportista=0;
    private int idEstadoMotorista=0;

    //Modelo
    private MotoristaModels motoristaModels = new MotoristaModels();
    //Constructor
    public AdminMotoristaBeans(){
        setMotoristaEntity(new MotoristaEntity());
    }

    //Metodos

    //Lista de motoristas por id de administrador de sesion
    public List<MotoristaEntity> getMotoritasid( ){
        return motoristaModels.listarMotoristaid();
    }


    //Ingresar un motorista
    public String ingresarMotorista() {
        if (motoristaModels.insertarMotoristacompleto(motoristaEntity, idAdminTransportista, idEstadoMotorista) != 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Motorista no Agregada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Agregado", "Motorista Agregado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        motoristaEntity=null;
        return "AdminTransportista/MotoristasIdSesion";
    }

    //editar motoristas
    public String editarMotoristas( ){
        if(motoristaModels.modificarMotoristacompleto(motoristaEntity, idEstadoMotorista, idAdminTransportista)!= 1){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Unidad de transporte no Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Actualizado", "Unidad de transporte Eliminada");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "AdminTransportista/MotoristasIdSesion";
    }

    //Obtener motorista por id
    public String seleccionarId(int motoristaId  ) {
        if (motoristaModels.obtenerMotoristaId(motoristaId) == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "No se pudo obtener motorista");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Obtenido", "Obtenido con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);
            motoristaEntity=motoristaModels.obtenerMotoristaId(motoristaId);

            idAdminTransportista=motoristaEntity.getAdministradorTransportistaByIdAdministradorTransportista().getIdAdministradorTransportista();
            idEstadoMotorista=motoristaEntity.getEstadosGeneralesByEstadoMotorista().getIdEstado();

        }
        return "AdminTransportista/MotoristasIdSesion";
    }


    //Eliminar motoristas
    public String eliminarMotoristas(int dato ) {
        if (motoristaModels.eliminarMotorista(dato) != 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Motorista no eliminado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Eliminado", "Motorista Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }


        return "AdminTransportista/MotoristasIdSesion";
    }


    //Set y Get entidad
    public MotoristaEntity getMotoristaEntity() {
        return motoristaEntity;
    }

    public void setMotoristaEntity(MotoristaEntity motoristaEntity) {
        this.motoristaEntity = motoristaEntity;
    }


    //set y get parametros de formulario MotoristasIdSesion
    public int getIdEstadoMotorista() {
        return idEstadoMotorista;
    }

    public void setIdEstadoMotorista(int idEstadoMotorista) {
        this.idEstadoMotorista = idEstadoMotorista;
    }

    public int getIdAdminTransportista() {
        return idAdminTransportista;
    }

    public void setIdAdminTransportista(int idAdminTransportista) {
        this.idAdminTransportista = idAdminTransportista;
    }

}
