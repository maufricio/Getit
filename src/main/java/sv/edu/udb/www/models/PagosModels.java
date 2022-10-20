package sv.edu.udb.www.models;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.PagosEntity;
import sv.edu.udb.www.entities.PagosEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class PagosModels {
    public List<PagosEntity>listaPagos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select e from PagosEntity e");

            java.util.List<sv.edu.udb.www.entities.PagosEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public PagosEntity obtenerPagos(int id){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            PagosEntity obtengo = em.find(PagosEntity.class, id);
            em.close();
            return obtengo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
}

