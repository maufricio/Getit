package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.models.MotoristaModels;

import java.util.List;

@ManagedBean
@RequestScoped
//Mauricio Perez
public class MotoristaBeans {
    private MotoristaEntity motoristaEntity;
    private MotoristaModels motoristaModels;

    public MotoristaBeans() {
        this.motoristaModels = new MotoristaModels();
        this.motoristaEntity = this.motoristaModels.getMotoristaById(5);
    }

    public List<PedidosEntity> getListaPedidosByMotorista() {
        return this.motoristaModels.getListaPedidosByIdMotorista(this.motoristaEntity.getIdMotorista());
    }
    /*
        public String prueba(MotoristaEntity motoristaEntity){
            motoristaModels.insertarMotorista(motoristaEntity);
            return "";
        }
    */






    public String getAdministradorTransportista() { return this.motoristaModels.getJefeTransportistaOfMotorista(this.motoristaEntity.getIdMotorista()); }

    public String getEstado() {
        return motoristaModels.getEstadoMotorista(this.motoristaEntity.getIdMotorista());
    }

    public MotoristaEntity getMotoristaEntity() {
        return motoristaEntity;
    }

    public void setMotoristaEntity(MotoristaEntity motoristaEntity) {
        this.motoristaEntity = motoristaEntity;
    }

    public MotoristaModels getMotoristaModels() {
        return motoristaModels;
    }

    public void setMotoristaModels(MotoristaModels motoristaModels) {
        this.motoristaModels = motoristaModels;
    }


}
