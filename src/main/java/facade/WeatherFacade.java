/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.AllWeatherDTO;
import dto.CityDTO;
import dto.WeatherDTO;
import java.util.List;
import utils.ExternalAPI;
import rest.FetchResourceCallable;

/**
 *
 * @author nr
 */
public class WeatherFacade {

    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//    private final Gson gson = new Gson();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    ExternalAPI EA = new ExternalAPI();

    private final String findCityId = EA.getApiMetaWeatherCity();
    private final String findWeatherForCity = EA.getApiMetaWeatherDataByCityId();

    public CityDTO getWoeidForCity(String cityname) throws Exception {
        CityDTO[] city = gson.fromJson(new FetchResourceCallable(findCityId + cityname).call(), CityDTO[].class);
        return city[0];
    }

    public List<WeatherDTO> getWeatherByCity(CityDTO city) throws Exception {
        AllWeatherDTO allWeatherDTO = gson.fromJson(new FetchResourceCallable(findWeatherForCity + city.getWoeid()).call(), AllWeatherDTO.class);
        return allWeatherDTO.getConsolidated_weather();
    }

    public String getWeatherSymbol(String abbreviation ){
        String url = "https://www.metaweather.com/static/img/weather/png/" +abbreviation+".png";
        return url;
    }
    
    public WeatherDTO getWeatherForToday(CityDTO city) throws Exception {
        return getWeatherByCity(city).get(0);
    }

    public String getFindCityId() {
        return findCityId;
    }

    public String getFindWeatherForCity() {
        return findWeatherForCity;
    }

}
