/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import dto.AllWeatherDTO;
import dto.CityDTO;
import dto.WeatherDTO;
import exceptions.CityNotFoundException;
import exceptions.ExternalServerError;
import java.util.ArrayList;
import java.util.List;
import threads.FetchCallable;
import utils.ExternalAPI;
import threads.FetchExecutor;

/**
 *
 * @author nr
 */
public class WeatherFacade {

    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private final Gson gson = new Gson();

    private ExternalAPI EA = new ExternalAPI();

    private List<String> fetchResultList;

    public List<String> getUrlsToFetchFromByCity(String cityname) {
        List<String> urls = new ArrayList();
        urls.add(EA.getApiMetaWeatherCity() + cityname);
        return urls;
    }

    public void fetchCityObjectAndEventsByCityName(String cityname) throws Exception {
        List<String> fetchUrls = getUrlsToFetchFromByCity(cityname);
        fetchResultList = new FetchExecutor(fetchUrls).run();
        if (fetchResultList.get(0).equals("[]")) { //Checking for empty array
            throw new CityNotFoundException();
        }
    }

    public CityDTO getWoeidForCity() throws Exception {
        CityDTO[] city = gson.fromJson(fetchResultList.get(0), CityDTO[].class);
        return city[0];
    }

    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception {
        fetchCityObjectAndEventsByCityName(cityname);
        AllWeatherDTO allWeatherDTO = gson.fromJson(new FetchCallable(EA.getApiMetaWeatherDataByCityId() + getWoeidForCity().getWoeid()).call(), AllWeatherDTO.class);
        return allWeatherDTO.getConsolidated_weather();
    }

    public WeatherDTO getWeatherForToday(String cityname) throws Exception {
        return getWeatherByCity(cityname).get(0);
    }

    public String getFindCityId() {
        return EA.getApiMetaWeatherCity();
    }

    public String getFindWeatherForCity() {
        return EA.getApiMetaWeatherDataByCityId();
    }

    public List<String> getFetchResultList() {
        return fetchResultList;
    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facade;
//
//import com.google.gson.Gson;
//import dto.AllWeatherDTO;
//import dto.CityDTO;
//import dto.WeatherDTO;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import utils.ExternalAPI;
//import rest.FetchResourceCallable;
//
///**
// *
// * @author nr
// */
//public class WeatherFacade {
//
//    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//    private final Gson gson = new Gson();
//
//    ExternalAPI EA = new ExternalAPI();
//
//    private final String findCityId = EA.getApiMetaWeatherCity();
//    private final String findWeatherForCity = EA.getApiMetaWeatherDataByCityId();
//
//    public CityDTO getWoeidForCity(String cityname) {
//        try{
//        CityDTO[] city = gson.fromJson(new FetchResourceCallable(findCityId + cityname).call(), CityDTO[].class);
//        return city[0];
//        } catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//
//    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception {
//        CityDTO cityDTO = getWoeidForCity(cityname);
//        AllWeatherDTO allWeatherDTO = gson.fromJson(new FetchResourceCallable(findWeatherForCity + cityDTO.getWoeid()).call(), AllWeatherDTO.class);
//        return allWeatherDTO.getConsolidated_weather();
//    }
//
//    public WeatherDTO getWeatherForToday(String cityname) throws Exception {
//        return getWeatherByCity(cityname).get(0);
//    }
//
//    public String getFindCityId() {
//        return findCityId;
//    }
//
//    public String getFindWeatherForCity() {
//        return findWeatherForCity;
//    }
//
//}
