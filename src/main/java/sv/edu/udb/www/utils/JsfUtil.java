package sv.edu.udb.www.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;

public class JsfUtil {

    public static void setErrorMessage(String idUser, String msg){
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(idUser,mensaje);
    }

    public static void setFlashMessage(String name, String msg){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, msg);
    }

    public static HttpServletRequest getRequest(){
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
