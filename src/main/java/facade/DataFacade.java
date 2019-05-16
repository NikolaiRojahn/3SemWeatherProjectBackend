package facade;

import interfaces.DataInterface;
import dto.SearchCityDTO;
import entity.SearchCity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DataFacade implements DataInterface{
    
    private static EntityManagerFactory emf;
    private static DataFacade instance;
    
    public DataFacade(){}
    
    public static DataFacade getInstance(EntityManagerFactory factory){
        if(instance == null){
          emf = factory;
          instance = new DataFacade();
        }
        return instance;
    }
    
    @Override
    public SearchCity getCitynameFromDB(String cityname) {
        EntityManager em = emf.createEntityManager();
        SearchCity searchCity;
        try {
            searchCity = em.find(SearchCity.class, 1);
        } finally {
            em.close();
        }
        return searchCity;
    }
    
    @Override
    public List<SearchCity> getAllCitynameFromDB() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<SearchCity> scList = new ArrayList();
            Query q = em.createQuery("SELECT sc FROM SearchCity sc");
            scList = q.getResultList();
            em.getTransaction().commit();
            return scList;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<SearchCityDTO> getMostSearchedCities() {
        EntityManager em = emf.createEntityManager();
        String queryStr = "SELECT NEW dto.SearchCityDTO (sc.cityname) FROM SearchCity AS sc GROUP BY sc.cityname ORDER BY count(sc) DESC";
        //MYSQL --> select cityname from searchcity GROUP BY cityname ORDER BY count(*) DESC limit 5;
        TypedQuery<SearchCityDTO> query = em.createQuery(queryStr, SearchCityDTO.class);
        query.setMaxResults(5);
        return query.getResultList();
    }
    
    @Override
    public SearchCity newSearchCity(String cityname) {
        SearchCity searchCity = new SearchCity(cityname);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(searchCity);
            em.getTransaction().commit();
            return searchCity;
        } finally {
            em.close();
        }
        
    }

}
