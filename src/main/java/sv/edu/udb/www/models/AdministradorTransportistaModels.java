package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.AdministradorTransportistaEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class AdministradorTransportistaModels {
    public List<AdministradorTransportistaEntity> listarEntrada() {
        //Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("Select E from AdministradorTransportistaEntity E");
            List<AdministradorTransportistaEntity> lista = consulta.getResultList();
            em.close();// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
}
