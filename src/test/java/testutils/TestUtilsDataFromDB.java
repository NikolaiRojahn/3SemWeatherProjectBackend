package testutils;

import entity.SearchCity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class TestUtilsDataFromDB {
  
  public static void setupTestDataFromDB(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      //System.out.println("XXXXXXXXXXXXXXXX  Creating Test users for TESTING XXXXXXXXXXXXXXXXXXXXXX");
      em.getTransaction().begin();
      //Delete existing users and roles to get a "fresh" database
      em.createQuery("delete from SearchCity").executeUpdate();
      SearchCity sc = new SearchCity("copenhagen");
      em.persist(sc);
      System.out.println("Saved test data to database");
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
  
}
