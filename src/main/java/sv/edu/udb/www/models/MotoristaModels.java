package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.entities.PedidosEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

//Mauricio Perez
public class MotoristaModels {

    public List<PedidosEntity> getListaPedidosByIdMotorista(Integer idMotorista) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM PedidosEntity e WHERE e.motoristaByIdMotorista.idMotorista = :idMotorista AND e.estadosPedidoByEstadoPedido.idEstado = :estadopedido", PedidosEntity.class);
            query.setParameter("idMotorista", idMotorista);
            query.setParameter("estadopedido", 2);
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

    /*public int insertarMotorista(MotoristaEntity motorista, int estado) { //Puede venir en forma de uno, 2 o 7
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            motorista.setEstadosGeneralesByEstadoMotorista(new EstadosGeneralesEntity());
            motorista.getEstadosGeneralesByEstadoMotorista().setEstado(String.valueOf(estado));
            motorista.getEstadosGeneralesByEstadoMotorista().getEstado();
            em.persist(motorista);
            tran.commit();
            return 1;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }*/

    public int insertarMotorista (MotoristaEntity motoristaEntity) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(motoristaEntity);
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

    public String getEstadoMotorista(Integer idMotorista) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            MotoristaEntity motoristaEntity = entityManager.find(MotoristaEntity.class, idMotorista);
            String estadoMotorista = motoristaEntity.getEstadosGeneralesByEstadoMotorista().getEstado();
            return estadoMotorista;
        } catch(Exception ex) {
            return "";
        } finally {
            entityManager.close();
        }
    }

    public String getJefeTransportistaOfMotorista(Integer idMotorista) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            MotoristaEntity motoristaEntity = em.find(
                    MotoristaEntity.class,
                    idMotorista
            );
            String adminTransportista = motoristaEntity.getAdministradorTransportistaByIdAdministradorTransportista().getNombreEmpresa();
            return adminTransportista;
        } catch(Exception ex) {
            return "";
        } finally {
            em.close();
        }
    }

    //Lista motorista por id sesion
    public List<MotoristaEntity> listarMotoristaid() {
        //Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("Select E from MotoristaEntity E where E.administradorTransportistaByIdAdministradorTransportista.idAdministradorTransportista=1");
            List<MotoristaEntity> lista = consulta.getResultList();
            em.close();// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    //Obtener un motoristas por su id
    public  MotoristaEntity obtenerMotoristaId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Recupero el objeto desde la BD a través del método find
            MotoristaEntity entrada = em.find(MotoristaEntity.class, id);
            em.close();
            return entrada;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    //Insertar motorista por parte del adminTransportista
    public int insertarMotoristacompleto(MotoristaEntity motoristaEntity,int idAdministradorp, int idEstadoMotorista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción

            motoristaEntity.setAdministradorTransportistaByIdAdministradorTransportista(new AdministradorTransportistaEntity());
            motoristaEntity.getAdministradorTransportistaByIdAdministradorTransportista().setIdAdministradorTransportista(idAdministradorp);
            motoristaEntity.setEstadosGeneralesByEstadoMotorista(new EstadosGeneralesEntity());
            motoristaEntity.getEstadosGeneralesByEstadoMotorista().setIdEstado(idEstadoMotorista);


            em.persist(motoristaEntity); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
    //modificar motorista por parte del adminTransportista
    public int modificarMotoristacompleto(MotoristaEntity motoristaEntity,int idestado, int idadministradorp) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {
            motoristaEntity.setAdministradorTransportistaByIdAdministradorTransportista(new AdministradorTransportistaEntity());
            motoristaEntity.getAdministradorTransportistaByIdAdministradorTransportista().setIdAdministradorTransportista(idadministradorp);
            motoristaEntity.setEstadosGeneralesByEstadoMotorista(new EstadosGeneralesEntity());
            motoristaEntity.getEstadosGeneralesByEstadoMotorista().setIdEstado(idestado);
            tran.begin();//Iniciando transacción
            em.merge(motoristaEntity); //Actualizando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
}
