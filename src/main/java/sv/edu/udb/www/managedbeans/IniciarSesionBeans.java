package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.AdministradorGetitEntity;
import sv.edu.udb.www.entities.AdministradorTransportistaEntity;
import sv.edu.udb.www.entities.ClientesEntity;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.models.IniciarSesionModels;
import sv.edu.udb.www.utils.JsfUtil;

@ManagedBean
@RequestScoped
//Mauricio Perez
public class IniciarSesionBeans {

    //Mandar codigo unico como password al email del usuario requestante de iniciar sesion
    //Dicho codigo tendrá un plazo de expiración de 30 min
    //Si el usuario desea relogearse dentro del plazo del tiempo, entonces tendrá un medio de almacenamiento
    //Que podrá ser la cookie del navegador para almacenarla, y poder volver a recuperarla

    private IniciarSesionModels iniciarSesionModels;
    private AdministradorGetitEntity administradorGetit;
    private AdministradorTransportistaEntity administradorTransportista;
    private MotoristaEntity motorista;
    private ClientesEntity cliente;

    public IniciarSesionBeans() {
        this.iniciarSesionModels = new IniciarSesionModels();
    }

    public String verifyExistentUser(String email) {
        //Verificar el id pedido existente
        //Pero antes de esto, traducir el correo introducido (Hecho en el models)
        this.administradorGetit = this.iniciarSesionModels.verifyExistingUserAdminGetit(email);
        this.administradorTransportista = this.iniciarSesionModels.verifyExistingUserAdminTransportista(email);
        this.motorista = this.iniciarSesionModels.verifyExistingUserMotorista(email);
        this.cliente = this.iniciarSesionModels.verifyExistingUserCliente(email);

        if(this.administradorGetit != null) {
            JsfUtil.setFlashMessage("Exito", "¡Administrador Getit ha iniciado sesión!");
            return ""; //Retornar a la vista de administrador getit
        }
        else if(this.administradorTransportista != null) {
            JsfUtil.setFlashMessage("Exito", "¡Administrador Transportista ha iniciado sesión!");
            return ""; //Retornar a la vista de administrador transportista
        }
        else if(this.motorista != null) {
            JsfUtil.setFlashMessage("Exito", "¡Motorista ha iniciado sesión!");
            return ""; //Retornar a la vista de motorista
        }
        else if(this.cliente != null) {
            JsfUtil.setFlashMessage("Exito", "¡Cliente ha iniciado sesión!");
            return ""; //Retornar a la vista de cliente
        }

        return "OpcionesUsuarios/iniciarSesion";
    }

    public IniciarSesionModels getIniciarSesionModels() {
        return iniciarSesionModels;
    }

    public void setIniciarSesionModels(IniciarSesionModels iniciarSesionModels) {
        this.iniciarSesionModels = iniciarSesionModels;
    }

    public AdministradorGetitEntity getAdministradorGetit() {
        return administradorGetit;
    }

    public void setAdministradorGetit(AdministradorGetitEntity administradorGetit) {
        this.administradorGetit = administradorGetit;
    }

    public AdministradorTransportistaEntity getAdministradorTransportista() {
        return administradorTransportista;
    }

    public void setAdministradorTransportista(AdministradorTransportistaEntity administradorTransportista) {
        this.administradorTransportista = administradorTransportista;
    }

    public MotoristaEntity getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaEntity motorista) {
        this.motorista = motorista;
    }

    public ClientesEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientesEntity cliente) {
        this.cliente = cliente;
    }
}