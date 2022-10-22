package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.AdministradorTransportistaEntity;
import sv.edu.udb.www.entities.EstadosGeneralesEntity;
import sv.edu.udb.www.entities.UnidadesTransporteEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

//Alex Villalta
public class UnidadesTransporteModels {

    public List<UnidadesTransporteEntity> listarUnidadesTransporteid() {
        //Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("Select E from UnidadesTransporteEntity E where E.administradorTransportistaByIdAdministradorTransportista.idAdministradorTransportista=1");
            List<UnidadesTransporteEntity> lista = consulta.getResultList();
            em.close();// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public  int insertarUnidadTransporte(UnidadesTransporteEntity unidadesTransporteEntity, int idestado, int idadministradorp ){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {
            tran.begin();//Iniciando transacción
            //una camino dentro de la relacion
            unidadesTransporteEntity.setAdministradorTransportistaByIdAdministradorTransportista(new AdministradorTransportistaEntity());
            unidadesTransporteEntity.getAdministradorTransportistaByIdAdministradorTransportista().setIdAdministradorTransportista(idadministradorp);
            unidadesTransporteEntity.setEstadosGeneralesByEstadoUnidad(new EstadosGeneralesEntity());
            unidadesTransporteEntity.getEstadosGeneralesByEstadoUnidad().setIdEstado(idestado);

            em.persist(unidadesTransporteEntity); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public UnidadesTransporteEntity obtenerUnidadTransporte(int idUnidadTransporte) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Recupero el objeto desde la BD a través del método find
            UnidadesTransporteEntity entrada = em.find(UnidadesTransporteEntity.class, idUnidadTransporte);
            em.close();
            return entrada;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int eliminarUnidadTransporte(int idUnidadTransporte) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            UnidadesTransporteEntity ent = em.find(UnidadesTransporteEntity.class, idUnidadTransporte);
            if (ent != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();//Iniciando transacción
                em.remove(ent);//Borrando la instancia
                tran.commit();//Confirmando la transacción
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
    public int modificarUnidadTransporte(UnidadesTransporteEntity unidadesTransporteEntity,int idestado, int idadministradorp) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {
            unidadesTransporteEntity.setAdministradorTransportistaByIdAdministradorTransportista(new AdministradorTransportistaEntity());
            unidadesTransporteEntity.getAdministradorTransportistaByIdAdministradorTransportista().setIdAdministradorTransportista(idadministradorp);
            unidadesTransporteEntity.setEstadosGeneralesByEstadoUnidad(new EstadosGeneralesEntity());
            unidadesTransporteEntity.getEstadosGeneralesByEstadoUnidad().setIdEstado(idestado);
            tran.begin();//Iniciando transacción
            em.merge(unidadesTransporteEntity); //Actualizando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
}
