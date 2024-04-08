package repositories;
import entities.Ban;
import jakarta.persistence.EntityManager;
import utils.JpaUtils;

import java.util.List;

public class FriendRepo {
       EntityManager entityManager = JpaUtils.getEntityManager();

       public List<Ban> getBanList() {
               return entityManager.createQuery("SELECT b FROM Ban b", Ban.class).getResultList();
       }

       public void update(Ban friend) {
               try {
                      entityManager.getTransaction().begin();
                      entityManager.merge(friend);
                      entityManager.getTransaction().commit();
               } catch (Exception e) {
                      entityManager.getTransaction().rollback();
                      e.printStackTrace();
               }
       }

       public void delete(Ban friend) {
               try {
                      entityManager.getTransaction().begin();
                      entityManager.remove(friend);
                      entityManager.getTransaction().commit();
               } catch (Exception e) {
                      entityManager.getTransaction().rollback();
                      e.printStackTrace();
               }
       }

       public Ban findById(int id){
              return entityManager.find(Ban.class, id);
       }

}
