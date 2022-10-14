package sv.edu.udb.www.models;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class ClientesModels {

    public List<PedidosEntity>listaPedidos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select e from PedidosEntity e");

            List<PedidosEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public PedidosEntity obtenerPedido(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            PedidosEntity obtengo = em.find(PedidosEntity.class, id);
            em.close();
            return obtengo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

}
