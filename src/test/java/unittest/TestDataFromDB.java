package unittest;

import entity.SearchCity;
import facade.DataFacade;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import testutils.TestUtilsDataFromDB;
import utils.PuSelector;
import static org.junit.Assert.*;

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
    
    @Test
    public void testNewSearchCity() {
        SearchCity searchCity = facade.newSearchCity("london");
        assertEquals("london", searchCity.getCityname());
    }
    
    @Test
    public void testCountAfterNewSearchCity() {
        facade.newSearchCity("london"); //Indsætter ny city i tabellen
        int expected = 2;
        int actual = facade.getAllCitynameFromDB().size();
        assertEquals(expected, actual);
    }

}
