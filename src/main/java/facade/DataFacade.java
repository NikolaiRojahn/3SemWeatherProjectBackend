package facade;

import dto.SearchCityDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DataFacade {
    
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
    
    public List<SearchCityDTO> getMostSearchedCities() {
        EntityManager em = emf.createEntityManager();
        String queryStr = "SELECT NEW dto.SearchCityDTO"
                + "sc.cityname"
                + "FROM SearchCity sc GROUP BY sc.cityname ORDER BY count(sc) DESC";
//MYSQL --> select cityname from searchcity GROUP BY cityname ORDER BY count(*) DESC limit 5;
        TypedQuery<SearchCityDTO> query = em.createQuery(queryStr, SearchCityDTO.class);
        query.setMaxResults(5);
        return query.getResultList();
    }

}
