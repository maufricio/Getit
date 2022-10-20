package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.validation.constraints.NotNull;
import org.primefaces.event.SelectEvent;
import sv.edu.udb.www.entities.ClientesEntity;
import sv.edu.udb.www.models.RegistroModels;
import sv.edu.udb.www.utils.JsfUtil;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class RegistrosBeans {

    private RegistroModels registrosModels;
    private ClientesEntity clientesEntity;


    public RegistrosBeans() {
        this.registrosModels = new RegistroModels();
        this.clientesEntity = new ClientesEntity();
    }

    public String registrarCliente() {
        if (this.registrosModels.signUpNewClientUser(this.clientesEntity) != 1) {
            JsfUtil.setErrorMessage(null, "No se pudo registrar a este cliente.");
        } else {
            JsfUtil.setFlashMessage("exito", "Usuario cliente registrado exitosamente.");

        }
        return "OpcionesUsuarios/registroCliente?faces-redirect=false";
    }

    //Para textarea complementada
    public List<String> completeArea(String query) {
        List<String> results = new ArrayList<>();

        if ("San Salvador".equals(query)) {
            results.add("San Salvador, Soyapango, Col. Las Flores");
            results.add("San Salvador, Soyapango, Col. Las Margaritas");
            results.add("San Salvador, San Salvador, Col. La Cima III");
        }
        else {
            for (int i = 0; i < 10; i++) {
                results.add(query + i);
            }
        }

        return results;
    }

    public void onSelect(SelectEvent<String> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "select", event.getObject()));
    }




    public RegistroModels getRegistrosModels() {
        return registrosModels;
    }

    public void setRegistrosModels(RegistroModels registrosModels) {
        this.registrosModels = registrosModels;
    }

    public ClientesEntity getClientesEntity() {
        return clientesEntity;
    }

    public void setClientesEntity(ClientesEntity clientesEntity) {
        this.clientesEntity = clientesEntity;
    }
}
