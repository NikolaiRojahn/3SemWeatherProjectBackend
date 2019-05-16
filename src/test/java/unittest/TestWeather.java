package unittest;

import dto.WeatherDTO;
import exceptions.CityNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import facade.WeatherFacade;
import java.util.ArrayList;
import java.util.List;

public class TestWeather {

    private WeatherFacade wf = new WeatherFacade();
    
    @Test
    public void testGetWoeidForCityLondon() throws Exception {
        String cityname = "london";
        int expected = 44418;
        int actual = wf.getWoeidForCity(cityname).getWoeid();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetWoeidForCityCopenhagen() throws Exception {
        String cityname = "copenhagen";
        int expected = 554890;
        int actual = wf.getWoeidForCity(cityname).getWoeid();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWeatherByCity() throws Exception {
        String cityname = "Copenhagen";
        int expected = 6;
        int actual = wf.getWeatherByCity(cityname).size();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetWeatherTodayByCity() throws Exception {
        String cityname = "Copenhagen";
        List<WeatherDTO> testTodayDTOList = new ArrayList();
        testTodayDTOList.add(wf.getWeatherForToday(cityname));
        int expected = 1;
        long actual = testTodayDTOList.size();
        assertEquals(expected, actual);
    }
    
    @Test(expected = CityNotFoundException.class)
    public void testGetCityNotFoundException() throws Exception  {
        String cityname = "Cofdsgdgpenhagen";
        wf.getWeatherByCity(cityname);
    }
    
    @Test
    public void testGetCityByCountry() throws Exception {
        int woeid = 23424796;
        int expected = 1;
        int actual = wf.getCityByCountry(woeid).size();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPackageByCity() throws Exception {
        int zipCode = 2500;
        int expected = 6;
        int actual = wf.getPackageByCity(zipCode).size();
        assertEquals(expected, actual);
    }
    
}