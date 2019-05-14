/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfaces.WeatherInterface;
import com.google.gson.Gson;
import dto.AllCityDTO;
import dto.AllPackageDTO;
import dto.AllWeatherDTO;
import dto.CityDTO;
import dto.PackageDTO;
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
public class WeatherFacade implements WeatherInterface{

    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private final Gson gson = new Gson();

    private ExternalAPI EA = new ExternalAPI();

    private List<String> fetchResultList;

    @Override
    public List<String> getUrlsToFetchFromByCity(String cityname) {
        List<String> urls = new ArrayList();
        urls.add(EA.getApiMetaWeatherCity() + cityname);
        urls.add(EA.getApiMetaPackage());
        return urls;
    }

    @Override
    public void fetchCityObjectAndEventsByCityName(String cityname) throws Exception {
        List<String> fetchUrls = getUrlsToFetchFromByCity(cityname);
        fetchResultList = new FetchExecutor(fetchUrls).run();
        if (fetchResultList.get(0).equals("[]")) { //Checking for empty array
            throw new CityNotFoundException();
        }
    }

    @Override
    public CityDTO getWoeidForCity() throws Exception {
        CityDTO[] city = gson.fromJson(fetchResultList.get(0), CityDTO[].class);
        return city[0];
    }

    @Override
    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception {
        fetchCityObjectAndEventsByCityName(cityname);
        AllWeatherDTO allWeatherDTO = gson.fromJson(new FetchCallable(EA.getApiMetaWeatherDataByCityId() + getWoeidForCity().getWoeid()).call(), AllWeatherDTO.class);
        return allWeatherDTO.getConsolidated_weather();
    }

    @Override
    public WeatherDTO getWeatherForToday(String cityname) throws Exception {
        return getWeatherByCity(cityname).get(0);
    }

    @Override
    public String getFindCityId() {
        return EA.getApiMetaWeatherCity();
    }

    @Override
    public String getFindWeatherForCity() {
        return EA.getApiMetaWeatherDataByCityId();
    }

    @Override
    public List<String> getFetchResultList() {
        return fetchResultList;
    }
    
    @Override
    public List<CityDTO> getCityByCountry(int woeid) throws Exception {
        //fetchCityObjectAndEventsByCityName(cityname);
        AllCityDTO allCityDTO = gson.fromJson(new FetchCallable(EA.getApiMetaWeatherDataByCityId() + woeid).call(), AllCityDTO.class);
        return allCityDTO.getChildren();
    }
    
    @Override
    public List<PackageDTO> getPackageByCity(int zipCode){
        AllPackageDTO allPackageDTO = gson.fromJson(fetchResultList.get(1), AllPackageDTO.class);
        return allPackageDTO.getPakkeshopData();
    }
    
    @Override
    public List<CityDTO> checkForSpaceInCityName(List<CityDTO> cities) {
        for (CityDTO citydto : cities ) {
            if(citydto.getTitle().contains(" ")){
            String[] splittedWords = citydto.getTitle().split(" ");
            String newTitle = splittedWords[(splittedWords.length - 1)];
            citydto.setTitle(newTitle);
            }
        }
        return cities;
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
