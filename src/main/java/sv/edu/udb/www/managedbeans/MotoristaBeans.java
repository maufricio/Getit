package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.models.MotoristaModels;

import java.util.List;

@ManagedBean
@RequestScoped
public class MotoristaBeans {
    private MotoristaEntity motoristaEntity;
    private MotoristaModels motoristaModels;

    public MotoristaBeans() {
        this.motoristaEntity = new MotoristaEntity();
        this.motoristaModels = new MotoristaModels();
    }

    public List<PedidosEntity> getListaPedidosByMotorista() {
        return this.motoristaModels.getListaPedidosByIdMotorista(1);
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
