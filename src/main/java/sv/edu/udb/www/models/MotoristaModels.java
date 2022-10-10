package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.ComidasEntity;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class MotoristaModels {

    public List<ComidasEntity> listarComidas() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            Query query = entityManager.createNamedQuery("Motorista.findAllComidas");
            List<ComidasEntity> listaComidas = (List<ComidasEntity>) query.getResultList();
            entityManager.close();
            return listaComidas;
        } catch(Exception ex) {
            entityManager.close();
            return null;
        }
    }

    public MotoristaEntity getMotoristaById(String idMotorista) throws Exception {
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
