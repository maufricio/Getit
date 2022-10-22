package sv.edu.udb.www.models;

import java.io.*;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import sv.edu.udb.www.entities.ClientesEntity;
import sv.edu.udb.www.entities.ComidasEntity;

import sv.edu.udb.www.utils.JpaUtil;

public class AdministradorGetitModels {

    public int insertarUsuario(ClientesEntity cliente){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(cliente);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            System.out.println("M: Error a la hora de ingresar un usuario: "  + e.getMessage());
            System.out.println("C: Error a la hora de ingresar un usuario: "  + e.getCause());
            em.close();
            return 0;
        }
    }

    public int insertarComida(ComidasEntity comida){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(comida);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            System.out.println("M: Error a la hora de ingresar comida: "  + e.getMessage());
            System.out.println("C: Error a la hora de ingresar comida: "  + e.getCause());
            em.close();
            return 0;
        }
    }

    public List<ClientesEntity> listarCliente(){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select e from ClientesEntity e");
            List<ClientesEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            System.out.println("M: Error al listar clientes: "  + e.getMessage());
            System.out.println("C: Error al listar clientes: "  + e.getCause());
            em.close();
            return null;
        }
    }

    /**public List<PedidosEntity> listarPedidos(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select pe from PedidosEntity pe inner join " +
                                                    "PagosEntity pa on pa.idPago = pe.idPagos INNER JOIN " +
                                                    "ComidasEntity co on co.idComida = pa.idComida " +
                                                    "INNER JOIN ClientesEntity cl on cl.idCliente = " +
                                                    "pa.idCliente inner JOIN EstadosPedidoEntity es on " +
                                                    "es.idEstado = pe.idEstadoP WHERE cl.idCliente =" + id);
            List<PedidosEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("M: Error a la hora de listar pedidos: " + e.getMessage());
            System.out.println("C: Error a la hora de listar pedidos: " + e.getCause());
            em.close();
            return null;
        }
    }*/

    public List<ComidasEntity> listarComida(){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select e from ComidasEntity e");
            List<ComidasEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            System.out.println("M: Error al listar comida: "  + e.getMessage());
            System.out.println("C: Error al listar comida: "  + e.getCause());
            em.close();
            return null;
        }
    }

    public int eliminarCliente(int idCliente){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ClientesEntity cl = em.find(ClientesEntity.class, idCliente);
            if(cl != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(cl);
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("M: Error a la hora de eliminar al cliente: " + e.getMessage());
            System.out.println("C: Error a la hora de eliminar el cliente: " + e.getCause());
            em.close();
            return 0;
        }
    }

    public int eliminarComida(int idComida){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ComidasEntity co = em.find(ComidasEntity.class, idComida);
            if(co != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(co);
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        }catch (Exception e){
            e.printStackTrace();
            em.close();
            return 0;
        }
    }

    public ClientesEntity obtenerCliente(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ClientesEntity cliente = em.find(ClientesEntity.class, id);
            em.close();
            return cliente;
        }catch (Exception e){
            e.printStackTrace();
            em.close();
            return null;
        }
    }

    public ComidasEntity obtenerComida(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ComidasEntity co = em.find(ComidasEntity.class, id);
            em.close();
            return co;
        }catch (Exception e){
            e.printStackTrace();
            em.close();
            return null;
        }
    }

    public int modificarCliente(ClientesEntity cliente){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(cliente);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            em.close();
            return 0;
        }
    }

    public int modificarComida(ComidasEntity comida){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(comida);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            em.close();
            return 0;
        }
    }



    /**public void getImg(int id){
        EntityManager em = JpaUtil.getEntityManager();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try{
            Query consulta = em.createQuery("select e from ComidasEntity e where e.idComida = " + id);
            inputStream = em.set
            em.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("M:Error al obtener la imagen: " + e.getMessage());
            System.out.println("C:Error al obtener la imagen: " + e.getCause());
        }
    }*/



}
