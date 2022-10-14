package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class MotoristaModels {

    public List<PedidosEntity> getListaPedidosByIdMotorista(Integer idMotorista) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM PedidosEntity e");
            List<PedidosEntity> pedidosEncargadosMotorista = (List<PedidosEntity>) query.getResultList();
            return pedidosEncargadosMotorista;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<MotoristaEntity> listMotoristas() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM MotoristaEntity e");
            List<MotoristaEntity> listaMotoristas = (List<MotoristaEntity>) query.getResultList();
            return listaMotoristas;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public int insertarMotorista(MotoristaEntity motorista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(motorista);
            tran.commit();
            return 1;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int modificarMotorista(MotoristaEntity motorista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            MotoristaEntity motoristaEntity = em.find(MotoristaEntity.class, motorista.getIdMotorista());
            if(motoristaEntity != null) {
                tran.begin();
                em.merge(motorista);
                tran.commit();
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int eliminarMotorista(int idMotorista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            MotoristaEntity motoristaEntity = em.find(MotoristaEntity.class, idMotorista);
            if(motoristaEntity != null) {
                tran.begin();
                em.remove(motoristaEntity);
                tran.commit();
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public MotoristaEntity getMotoristaById(Integer idMotorista) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            MotoristaEntity motoristaEntity = entityManager.find(MotoristaEntity.class, idMotorista);
            entityManager.close();
            return motoristaEntity;
        } catch(Exception ex) {
            entityManager.close();
            return null;
        }
    }
}
