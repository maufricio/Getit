package sv.edu.udb.www.managedbeans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.IOUtils;
import sv.edu.udb.www.entities.ClientesEntity;
import sv.edu.udb.www.entities.ComidasEntity;

import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.models.AdministradorGetitModels;
import sv.edu.udb.www.utils.JsfUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class AdministradorGetitBeans {

    private ClientesEntity cliente;
    private ComidasEntity comida;

    private PedidosEntity pedidos;

    private UploadedFile img;

    private String primerNombre;
    private String primerApellido;
    private String email;
    private Date fechaNac;
    private String domicilio;



    AdministradorGetitModels adminmodelo = new AdministradorGetitModels();

    private List<ClientesEntity> listaClientes;
    private List<ComidasEntity> lidateComida;
    private List<PedidosEntity> listaPedidos;

    public AdministradorGetitBeans(){
        cliente = new ClientesEntity();
        comida = new ComidasEntity();
        pedidos = new PedidosEntity();

    }


    public String guardarUsuario(){
        if(adminmodelo.insertarUsuario(cliente) != 1){
            JsfUtil.setErrorMessage(null, "Usuario ya ingresado");
            return null;
            }else{
            JsfUtil.setFlashMessage("exito", "Usuario registrado exitosamente");
            return "listaClientes?faces-redirect=true";
        }
    }





    public void covertToImg() throws ServletException, IOException {
        if(img != null) {
            try {

                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
                InputStream inputStream = img.getInputStream();
                byte[] myimg = IOUtils.toByteArray(inputStream);

                comida.setImagenComida(myimg);

            } catch (IOException s) {
                System.out.println("M: Error convirtiendo img: " + s.getMessage());
                System.out.println("M: Error convirtiendo img: " + s.getCause());
                s.printStackTrace();
                FacesMessage message = new FacesMessage("Hubo un problema tu imagen no fue subida", s.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                System.out.println("M: Error convirtiendo img: " + e.getMessage());
                System.out.println("C: Error convirtiendo img: " + e.getCause());
            }
        }
    }

    public String eliminarCliente(){
        int idCliente = Integer.parseInt(JsfUtil.getRequest().getParameter("id"));

        if(adminmodelo.eliminarCliente(idCliente) > 0){
            JsfUtil.setFlashMessage("exito", "Cliente eliminado");
        }else{
            JsfUtil.setErrorMessage(null, "No se pudo eliminar el cliente");
        }
        return "listaClientes?faces-redirect=true";
    }

    public String eliminarComida(){
        int idComida = Integer.parseInt(JsfUtil.getRequest().getParameter("id"));

        if(adminmodelo.eliminarComida(idComida) > 0){
            JsfUtil.setFlashMessage("exito", "Comida eliminada");
        }else{
            JsfUtil.setErrorMessage(null, "No se pudo eliminar la comida");
        }
        return "agregarComida?faces-redirect=true";
    }

    public void actualizarCliente(){
        int id = Integer.parseInt(JsfUtil.getRequest().getParameter("id"));
        AdministradorGetitModels administradorGetitModels = new AdministradorGetitModels();
        ClientesEntity clientes = administradorGetitModels.obtenerCliente(id);

        if(clientes != null){

            cliente.setIdCliente(clientes.getIdCliente());
            cliente.setPrimerNombre(clientes.getPrimerNombre());
            cliente.setPrimerApellido(clientes.getPrimerApellido());
            cliente.setEmail(clientes.getEmail());
            cliente.setFechaNac(clientes.getFechaNac());
            cliente.setDomicilio(clientes.getDomicilio());

            System.out.println("Cliente encontrado");

        }else {
            JsfUtil.setErrorMessage(null, "No se encontro el cliente");
            System.out.println("Error cliente null");
        }
    }

    public void actualizarComida() throws ServletException, IOException{
        int id = Integer.parseInt(JsfUtil.getRequest().getParameter("id"));
        AdministradorGetitModels administradorGetitModels = new AdministradorGetitModels();
        ComidasEntity comidas = administradorGetitModels.obtenerComida(id);

        if(comidas != null){
            comida.setIdComida(comidas.getIdComida());
            comida.setNombreComida(comidas.getNombreComida());
            comida.setPrecioComida(comidas.getPrecioComida());
            comida.setPrecioComida(comidas.getPrecioComida());
            comida.setTipoOfertaComida(comidas.getTipoOfertaComida());
            comida.setStockComida(comidas.getStockComida());

            comida.setImagenComida(comidas.getImagenComida());
        }else {
            JsfUtil.setErrorMessage(null, "No se encontro la comida");
            System.out.println("Error comida null");
        }
    }


    public String modificarCliente(){
        if(adminmodelo.modificarCliente(cliente) != 0){
            JsfUtil.setFlashMessage("exito", "Usuario modificado exitosamente");
            return "listaClientes?faces-redirect=true";
        }else{
            JsfUtil.setFlashMessage(null, "Cliente no actualizado");
            return null;
        }
    }


    public String guardarComida() throws ServletException, IOException {

        covertToImg();

        if(adminmodelo.modificarComida(comida) != 0){
            JsfUtil.setFlashMessage("exito", "Exito!");
            return "agregarComida?faces-redirect=true";
        }else if(adminmodelo.insertarComida(comida) != 1){
            JsfUtil.setErrorMessage(null, "Error");
            return null;
        }else if(adminmodelo.modificarComida(comida) != 1){
            JsfUtil.setErrorMessage(null, "No pudo modificarse");
            return null;
        }else if(adminmodelo.insertarComida(comida) != 0){
            JsfUtil.setFlashMessage("exito", "Comida registrada exitosamente");
            return "agregarComida?faces-redirect=true";
        }

        return "agregarComida?faces-redirect=true";
    }

    public String redireccionarTablaPedidos(){ return "pedidosTabla?faces-redirect=true";}

    public String redListaClientes(){
        return "listaClientes.xhtml";
    }

    public String redComidas(){
        return "agregarComida.xhtml";
    }













    /**       GETTERS AND SETTERS   */

    public List<ClientesEntity> getListaClientes(){
        return adminmodelo.listarCliente();
    }
    public ClientesEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientesEntity cliente) {
        this.cliente = cliente;
    }

    public List<ComidasEntity> getListaComida(){
        return adminmodelo.listarComida();
    }

    public ComidasEntity getComida(){
        return comida;
    }

    public void setComida(ComidasEntity comida){
        this.comida = comida;
    }

    public UploadedFile getImg() {
        return img;
    }

    public void setImg(UploadedFile img) {
        this.img = img;
    }

    public List<PedidosEntity> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidosEntity> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
