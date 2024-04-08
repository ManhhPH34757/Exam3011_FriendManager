package repositories;

import entities.MoiQuanHe;
import jakarta.persistence.EntityManager;
import utils.JpaUtils;

import java.util.List;

public class RelationshipRepo {
       EntityManager entityManager = JpaUtils.getEntityManager();
       public List<MoiQuanHe> getRelationships(){
              return entityManager.createQuery("SELECT m FROM MoiQuanHe m", MoiQuanHe.class).getResultList();
       }

       public MoiQuanHe findById(int id) {
              return entityManager.find(MoiQuanHe.class, id);
       }
}
