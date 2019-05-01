/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CityDTO;
import dto.WeatherDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static javax.ws.rs.client.Entity.json;
import utils.ExternalAPI;
import rest.FetchResourceCallable;

/**
 *
 * @author nr
 */
public class WeatherFacade {
    
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private final Gson gson = new Gson();
    private final Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
    
    ExternalAPI EA = new ExternalAPI();
    FetchResourceCallable frc;
    
    private final String findCityId = EA.getApiMetaWeatherCity();
    private final String findWeatherForCity = EA.getApiMetaWeatherDataByCityId();

    public List<CityDTO> getWoeidForCity(String cityname) throws Exception {
        System.out.println(new FetchResourceCallable(findCityId + cityname).call());
        List<CityDTO> city =  (List<CityDTO>) gson.fromJson(new FetchResourceCallable(findCityId + cityname).call(), CityDTO.class);
        return city;
    }

    public List<WeatherDTO> getWeatherByCity(CityDTO city) throws Exception {
        List<WeatherDTO> weather = new ArrayList();
        weather.add(gson.fromJson(new FetchResourceCallable(findWeatherForCity).call(), WeatherDTO.class));
        return weather;
    }
    
    public WeatherDTO getWeatherForToday(CityDTO city) throws Exception {
        List<WeatherDTO> weatherToday = getWeatherByCity(city);
        return weatherToday.get(0);
    }

    public String getFindCityId() {
        return findCityId;
    }

    public String getFindWeatherForCity() {
        return findWeatherForCity;
    }
    
//    public static void main(String[] args) {
//        WeatherFacade wf = new WeatherFacade();
//        System.out.println(wf.getFindCityId());
//        System.out.println(wf.getFindWeatherForCity());
//    }
    
}
