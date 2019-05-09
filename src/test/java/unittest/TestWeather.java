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
    public void testGetUrlsToFetchFromByCity() {
        String cityname = "copenhagen";
        int expected = 1;
        int actual = wf.getUrlsToFetchFromByCity(cityname).size();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFetchCityObjectAndEventsByCityName() throws Exception {
        String cityname = "copenhagen";
        int expected = 1;
        wf.fetchCityObjectAndEventsByCityName(cityname);
        int actual = wf.getFetchResultList().size();
        assertEquals(expected, actual);
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
    public void testGetWoeidForCityLondon() throws Exception {
        String cityname = "london";
        int expected = 44418;
        wf.fetchCityObjectAndEventsByCityName(cityname);
        int actual = wf.getWoeidForCity().getWoeid();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetWoeidForCityCopenhagen() throws Exception {
        String cityname = "copenhagen";
        int expected = 554890;
        wf.fetchCityObjectAndEventsByCityName(cityname);
        int actual = wf.getWoeidForCity().getWoeid();
        assertEquals(expected, actual);
    }

    @Test
    public void getWeatherByCity() throws Exception {
        String cityname = "Copenhagen";
        int expected = 6;
        int actual = wf.getWeatherByCity(cityname).size();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getWeatherTodayByCity() throws Exception {
        String cityname = "Copenhagen";
        List<WeatherDTO> testTodayDTOList = new ArrayList();
        testTodayDTOList.add(wf.getWeatherForToday(cityname));
        int expected = 1;
        long actual = testTodayDTOList.size();
        assertEquals(expected, actual);
    }
    
    @Test(expected = CityNotFoundException.class)
    public void getCityNotFoundException() throws Exception  {
        String cityname = "Cofdsgdgpenhagen";
        wf.fetchCityObjectAndEventsByCityName(cityname);
    }
    
}