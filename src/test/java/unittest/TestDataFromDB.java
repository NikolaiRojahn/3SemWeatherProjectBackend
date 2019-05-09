package unittest;

import dto.SearchCityDTO;
import entity.SearchCity;
import facade.DataFacade;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import testutils.TestUtilsDataFromDB;
import utils.PuSelector;
import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.List;

public class TestDataFromDB {
    
    private static DataFacade facade;
    
    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu_unit_test_mock");
        facade = DataFacade.getInstance(emf);
        TestUtilsDataFromDB.setupTestDataFromDB(emf);
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testGetCitynameFromDB() {
        SearchCity searchCity = facade.getCitynameFromDB("copenhagen");
        assertEquals("copenhagen", searchCity.getCityname());
    }

}
