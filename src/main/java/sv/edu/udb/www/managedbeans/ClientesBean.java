package sv.edu.udb.www.managedbeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.models.ClientesModels;

import java.util.List;

@ManagedBean
@RequestScoped
//Marlon Realegueño
public class ClientesBean {
    private PedidosEntity pedido;

    private ClientesModels model = new ClientesModels();


    public ClientesBean() {
        pedido = new PedidosEntity();
    }

    public List<PedidosEntity> getPedidos() {
        return model.listaPedidos();
    }


    public PedidosEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidosEntity pedido) {
        this.pedido = pedido;
    }

    public ClientesModels getModel() {
        return model;
    }

    public void setModel(ClientesModels model) {
        this.model = model;
    }
}