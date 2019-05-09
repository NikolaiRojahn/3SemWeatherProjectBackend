//package unittest;

//import entity.User;
//import entity.UserFacade;
//import exceptions.AuthenticationException;
//import exceptions.CityNotFoundException;
//import exceptions.ExternalServerError;
//import javax.persistence.EntityManagerFactory;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import testutils.TestUtils;
//import utils.PuSelector;
//import java.util.ArrayList;
//import java.util.List;

//public class TestUsers {

//    private static UserFacade facade;

//    @BeforeClass
//    public static void setUpClass() {
//        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu_unit_test_mock");
//        facade = UserFacade.getInstance(emf);
//        TestUtils.setupTestUsers(emf);
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Test
//    public void getUserValid() throws AuthenticationException {
//        User u = facade.getVeryfiedUser("user", "test");
//        assertEquals("user", u.getUserName());
//    }
//
//    @Test(expected = AuthenticationException.class)
//    public void getUserInValid() throws AuthenticationException {
//        User u = facade.getVeryfiedUser("user", "testxxxx");
//        assertEquals("user", u.getUserName());
//    }
    
//}

//package unittest;
//
//import dto.CityDTO;
//import dto.WeatherDTO;
//import entity.User;
//import entity.UserFacade;
//import exceptions.AuthenticationException;
//import javax.persistence.EntityManagerFactory;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import testutils.TestUtils;
//import utils.PuSelector;
//import facade.WeatherFacade;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestUsers {
//
//    private static UserFacade facade;
//    private WeatherFacade wf = new WeatherFacade();
//
//    @BeforeClass
//    public static void setUpClass() {
//        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu_unit_test_mock");
//        facade = UserFacade.getInstance(emf);
//        TestUtils.setupTestUsers(emf);
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Test
//    public void getUserValid() throws AuthenticationException {
//        User u = facade.getVeryfiedUser("user", "test");
//        assertEquals("user", u.getUserName());
//    }
//
//    @Test(expected = AuthenticationException.class)
//    public void getUserInValid() throws AuthenticationException {
//        User u = facade.getVeryfiedUser("user", "testxxxx");
//        assertEquals("user", u.getUserName());
//    }
//
//    @Test
//    public void getUrlFindCityId() {
//        String expectedUrl = "https://www.metaweather.com/api/location/search/?query=";
//        String actualUrl = wf.getFindCityId();
//        assertEquals(expectedUrl, actualUrl);
//    }
//
//    @Test
//    public void getUrlFindWeatherByCityId() {
//        String expectedUrl = "https://www.metaweather.com/api/location/";
//        String actualUrl = wf.getFindWeatherForCity();
//        assertEquals(expectedUrl, actualUrl);
//    }
//    
//    @Test
//    public void testGetWoeidForCityLondon() throws Exception {
//        String cityname = "london";
//        int expected = 44418;
//        int actual = wf.getWoeidForCity(cityname).getWoeid();
//        assertEquals(expected, actual);
//    }
//    
//    @Test
//    public void testGetWoeidForCityCopenhagen() throws Exception {
//        String cityname = "copenhagen";
//        int expected = 554890;
//        int actual = wf.getWoeidForCity(cityname).getWoeid();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getWeatherByCity() throws Exception {
//        String cityname = "Copenhagen";
//        int expected = 6;
//        int actual = wf.getWeatherByCity(cityname).size();
//        assertEquals(expected, actual);
//    }
//    
//    @Test
//    public void getWeatherTodayByCity() throws Exception {
//        String cityname = "Copenhagen";
//        List<WeatherDTO> testTodayDTOList = new ArrayList();
//        testTodayDTOList.add(wf.getWeatherForToday(cityname));
//        int expected = 1;
//        long actual = testTodayDTOList.size();
//        assertEquals(expected, actual);
//    }
//    
//}
