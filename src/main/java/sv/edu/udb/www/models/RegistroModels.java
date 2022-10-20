//Mauricio Perez - 18-10-2022
package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.*;
import sv.edu.udb.www.utils.JpaUtil;

//Mauricio Perez
public class RegistroModels {

    //Verificar si no hay otro usuario con el mismo email y dui
    //En caso contrario, proceder a guardar en la base de datos el registro
    //En caso de que exista, decirle al usuario lo siguiente: "Asegurarse de digitar bien su correo electrónico
    // o puede que esté inválido en estos momentos." --> Debido a que si se le dice especificamente que ya hay
    //un registro con ese usuario, entonces pueden haber problemas de seguridad.

    private int verifyExistenceOfCliente(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM ClientesEntity e WHERE e.email = :email");
            query.setParameter("email", email);
            ClientesEntity cliente = (ClientesEntity) query.getSingleResult();
            if(cliente != null) {
                System.out.println("Se encontro un registro con este email: " + email);
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistenceOfAdminGetit(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM AdministradorGetitEntity e WHERE e.email = :email");
            query.setParameter("email", email);
            AdministradorGetitEntity administradorGetit = (AdministradorGetitEntity) query.getSingleResult();
            if(administradorGetit != null) {
                System.out.println("Se encontró un registro con este email: " + email);
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistenceOfAdminTransportista(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM AdministradorTransportistaEntity e WHERE e.email = :email");
            query.setParameter("email", email);
            AdministradorTransportistaEntity administradorTransportista = (AdministradorTransportistaEntity) query.getSingleResult();
            if(administradorTransportista != null) {
                System.out.println("Se encontro un registro con este email: "+email);
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistenceOfMotorista(String email, String dui) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM MotoristaEntity e WHERE e.email = :email AND e.dui = :dui");
            query.setParameter("email", email);
            query.setParameter("dui", dui);
            MotoristaEntity motorista = (MotoristaEntity) query.getSingleResult();
            if(motorista != null) {
                System.out.println("Se encontró un registro con este email: " + email + "y su DUI: " + dui);
                return 1;
            }
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    private int verifyExistenceOfUnidadTransporte(String placa) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM UnidadesTransporteEntity e WHERE e.placa = :placa");
            query.setParameter("placa", placa);
            UnidadesTransporteEntity unidadesTransporte = (UnidadesTransporteEntity) query.getSingleResult();
            if(unidadesTransporte != null)
                return 1;
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int signUpNewClientUser(ClientesEntity clientesEntity) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            int existenciaCliente = this.verifyExistenceOfCliente(clientesEntity.getEmail());
            int existenciaMotorista = this.verifyExistenceOfMotorista(clientesEntity.getEmail(), "");
            int existenciaAdminGetit = this.verifyExistenceOfAdminGetit(clientesEntity.getEmail());
            int existenciaAdminTransportista = this.verifyExistenceOfAdminTransportista(clientesEntity.getEmail());

            if(existenciaCliente != 1 && existenciaMotorista != 1 && existenciaAdminGetit != 1 && existenciaAdminTransportista != 1) {
                tran.begin();
                em.persist(clientesEntity);
                tran.commit();
                System.out.println("Usuario añadido con exito");
                return 1;
            }
            System.out.println("Usuario : "+clientesEntity.getPrimerNombre() + " "+ clientesEntity.getPrimerApellido() +" no se ha podido añadir");
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int signUpNewAdministradorTransportistaUser(AdministradorTransportistaEntity administradorTransportista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            int existenciaCliente = this.verifyExistenceOfCliente(administradorTransportista.getEmail());
            int existenciaMotorista = this.verifyExistenceOfMotorista(administradorTransportista.getEmail(), "");
            int existenciaAdminGetit = this.verifyExistenceOfAdminGetit(administradorTransportista.getEmail());
            int existenciaAdminTransportista = this.verifyExistenceOfAdminTransportista(administradorTransportista.getEmail());

            if(existenciaCliente != 1 && existenciaMotorista != 1 && existenciaAdminGetit != 1 && existenciaAdminTransportista != 1) {
                tran.begin();
                em.persist(administradorTransportista);
                tran.commit();
                System.out.println("Usuario añadido con exito");
                return 1;
            }
            System.out.println("Empresa : "+administradorTransportista.getNombreEmpresa() +
                     ", "+ administradorTransportista.getEmail() + " no se ha podido añadir");
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int signUpNewMotoristaUser(MotoristaEntity motoristaEntity) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            int existenciaCliente = this.verifyExistenceOfCliente(motoristaEntity.getEmail());
            int existenciaMotorista = this.verifyExistenceOfMotorista(motoristaEntity.getEmail(), motoristaEntity.getDui());
            int existenciaAdminGetit = this.verifyExistenceOfAdminGetit(motoristaEntity.getEmail());
            int existenciaAdminTransportista = this.verifyExistenceOfAdminTransportista(motoristaEntity.getEmail());

            if(existenciaCliente != 1 && existenciaMotorista != 1 && existenciaAdminGetit != 1 && existenciaAdminTransportista != 1) {
                tran.begin();
                em.persist(motoristaEntity);
                tran.commit();
                System.out.println("Usuario añadido con exito");
                return 1;
            }
            System.out.println("Empresa : "+motoristaEntity.getEmail() +
                    ", "+ motoristaEntity.getDui() + " no se ha podido añadir");
            return 0;
        } catch(Exception e) {
            return 0;
        } finally {
            em.close();
        }
    }

    public int signUpNewUnidadTransporte(
            UnidadesTransporteEntity unidadesTransporteEntity,
            int estadoUnidad,
            AdministradorTransportistaEntity administradorTransportista) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            int resultadoUnidadTransporte = this.verifyExistenceOfUnidadTransporte(unidadesTransporteEntity.getPlaca());
            if(resultadoUnidadTransporte != 1) {
                tran.begin();
                unidadesTransporteEntity.setEstadosGeneralesByEstadoUnidad(new EstadosGeneralesEntity());
                unidadesTransporteEntity.getEstadosGeneralesByEstadoUnidad().setIdEstado(estadoUnidad);
                unidadesTransporteEntity
                        .setAdministradorTransportistaByIdAdministradorTransportista
                                (
                                        new AdministradorTransportistaEntity()
                                );
                unidadesTransporteEntity.
                        getAdministradorTransportistaByIdAdministradorTransportista()
                        .setIdAdministradorTransportista(
                                administradorTransportista
                                        .getIdAdministradorTransportista()
                        );
                em.persist(unidadesTransporteEntity);
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
}