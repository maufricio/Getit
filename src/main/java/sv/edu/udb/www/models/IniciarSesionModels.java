package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.*;
import sv.edu.udb.www.utils.JpaUtil;

//Mauricio Perez

public class IniciarSesionModels {

    public MotoristaEntity verifyExistingUserMotorista(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            int idEncontrado = this.verifyExistingUserMotoristaByEmail(email);
            if(idEncontrado != 0) {
                MotoristaEntity motoristaEntity = em.find(MotoristaEntity.class, idEncontrado);
                return motoristaEntity;
            }
            return null;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public AdministradorGetitEntity verifyExistingUserAdminGetit(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            int idEncontrado = this.verifyExistingUserAdminGetitByEmail(email);
            if(idEncontrado != 0) {
                AdministradorGetitEntity administradorGetit = em.find(AdministradorGetitEntity.class, idEncontrado);
                return administradorGetit;
            }
            return null;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public AdministradorTransportistaEntity verifyExistingUserAdminTransportista(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            int idEncontrado = this.verifyExistingUserAdminTransportistaByEmail(email);
            if(idEncontrado != 0) {
                AdministradorTransportistaEntity administradorTransportista = em.find(AdministradorTransportistaEntity.class, idEncontrado);
                return administradorTransportista;
            }
            return null;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public ClientesEntity verifyExistingUserCliente(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            int idEncontrado = this.verifyExistingUserClienteByEmail(email);
            if(idEncontrado != 0) {
                ClientesEntity cliente = em.find(ClientesEntity.class, idEncontrado);
                return cliente;
            }
            return null;
        } catch(Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    private int verifyExistingUserMotoristaByEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Mandar a traer segun su email ingresado
            String sql = "SELECT e FROM MotoristaEntity e WHERE e.email = :email";
            Query query = em.createQuery(sql);
            query.setParameter("email", email);
            MotoristaEntity motorista = (MotoristaEntity) query.getSingleResult(); //Almacenar el objeto encontrado
            if(motorista != null)
                return motorista.getIdMotorista(); //Se le devuelve el id real que se encontro de motorista
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistingUserAdminGetitByEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Mandar a traer segun su email ingresado
            String sql = "SELECT e FROM AdministradorGetitEntity e WHERE e.email = :email";
            Query query = em.createQuery(sql);
            query.setParameter("email", email);
            AdministradorGetitEntity administradorGetit = (AdministradorGetitEntity) query.getSingleResult(); //Almacenar el objeto encontrado
            if(administradorGetit != null)
                return administradorGetit.getIdAdministradorGetit(); //Se le devuelve el id real que se encontró de administrador getit
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistingUserAdminTransportistaByEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Mandar a traer segun su email ingresado
            String sql = "SELECT e FROM AdministradorTransportistaEntity e WHERE e.email = :email";
            Query query = em.createQuery(sql);
            query.setParameter("email", email);
            AdministradorTransportistaEntity administradorTransportista = (AdministradorTransportistaEntity) query.getSingleResult(); //Almacenar el objeto encontrado
            if(administradorTransportista != null)
                return administradorTransportista.getIdAdministradorTransportista(); //Se le devuelve el id real que se encontró de administrador transportista
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistingUserClienteByEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Mandar a traer segun su email ingresado
            String sql = "SELECT e FROM ClientesEntity e WHERE e.email = :email";
            Query query = em.createQuery(sql);
            query.setParameter("email", email);
            ClientesEntity cliente = (ClientesEntity) query.getSingleResult(); //Almacenar el objeto encontrado
            if(cliente != null)
                return cliente.getIdCliente();
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }
}