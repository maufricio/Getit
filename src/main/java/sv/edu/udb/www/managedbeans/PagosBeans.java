package sv.edu.udb.www.managedbeans;

//Marlon Realegeño

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.PagosEntity;
import sv.edu.udb.www.models.PagosModels;

import java.util.List;

@ManagedBean
@RequestScoped

public class PagosBeans {

    private PagosEntity pagos;

    private PagosModels model = new PagosModels();

    public PagosBeans() {
        pagos = new PagosEntity();
    }

    public List<PagosEntity> getListaPagos() {
        return model.listaPagos();
    }


    public PagosEntity getPagos() {
        return pagos;
    }


    public void setPagos(PagosEntity pagos) {
        this.pagos = pagos;
    }

    public PagosModels getModel() {
        return model;
    }

    public void setModel(PagosModels model) {
        this.model = model;
    }
}
