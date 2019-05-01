package unittest;

import dto.CityDTO;
import entity.User;
import entity.UserFacade;
import exceptions.AuthenticationException;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testutils.TestUtils;
import utils.PuSelector;
import facade.WeatherFacade;
import rest.FetchResourceCallable;

public class TestUsers {

    private static UserFacade facade;
    private WeatherFacade wf = new WeatherFacade();

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu_unit_test_mock");
        facade = UserFacade.getInstance(emf);
        TestUtils.setupTestUsers(emf);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void getUserValid() throws AuthenticationException {
        User u = facade.getVeryfiedUser("user", "test");
        assertEquals("user", u.getUserName());
    }

    @Test(expected = AuthenticationException.class)
    public void getUserInValid() throws AuthenticationException {
        User u = facade.getVeryfiedUser("user", "testxxxx");
        assertEquals("user", u.getUserName());
    }

    @Test
    public void getUrlFindCityId() {
        String expectedUrl = "https://www.metaweather.com/api/location/search/?query=";
        String actualUrl = wf.getFindCityId();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void getUrlFindWeatherByCityId() {
        String expectedUrl = "https://www.metaweather.com/api/location/";
        String actualUrl = wf.getFindWeatherForCity();
        assertEquals(expectedUrl, actualUrl);
    }
    
    @Test
    public void testGetWoeidForCity() throws Exception {
        String cityname = "london";
        int expected = 44418;
        int actual = wf.getWoeidForCity(cityname).get(0).getWoeid();
        assertEquals(expected, actual);
    }

}
