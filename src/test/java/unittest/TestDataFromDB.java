package unittest;

import facade.DataFacade;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.PuSelector;

public class TestDataFromDB {
    
    private static DataFacade facade;
    
    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu_unit_test_mock");
        facade = DataFacade.getInstance(emf);
//        TestUtils.setupTestUsers(emf);
    }

    @AfterClass
    public static void tearDownClass() {
    }

}
