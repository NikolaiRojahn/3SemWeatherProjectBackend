package facade;

import interfaces.WeatherInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import dto.AllCityDTO;
import dto.AllPackageDTO;
import dto.AllWeatherDTO;
import dto.CityDTO;
import dto.PackageDTO;
import dto.WeatherDTO;
import exceptions.CityNotFoundException;
import java.util.List;
import utils.ExternalAPI;
import threads.SingleFutureCallable;

public class WeatherFacade implements WeatherInterface {

    private final Gson gson = new Gson();

    private ExternalAPI EA = new ExternalAPI();

    @Override
    public CityDTO getWoeidForCity(String cityname) throws Exception {
        String test = new SingleFutureCallable().run(EA.getApiMetaWeatherCity() + cityname);
        if(test.equals("[]")){
            throw new CityNotFoundException();
        }
        CityDTO[] city = gson.fromJson(test, CityDTO[].class);
        return city[0];
    }

    @Override
    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception {
        AllWeatherDTO allWeatherDTO = gson.fromJson(new SingleFutureCallable().run(EA.getApiMetaWeatherDataByCityId() + getWoeidForCity(cityname).getWoeid()), AllWeatherDTO.class);
        return allWeatherDTO.getConsolidated_weather();
    }

    @Override
    public WeatherDTO getWeatherForToday(String cityname) throws Exception {
        return getWeatherByCity(cityname).get(0);
    }

    @Override
    public List<CityDTO> getCityByCountry(int woeid) throws Exception {
        AllCityDTO allCityDTO = gson.fromJson(new SingleFutureCallable().run(EA.getApiMetaWeatherDataByCityId() + woeid), AllCityDTO.class);
        return checkForSpaceInCityName(allCityDTO.getChildren());
        //return allCityDTO.getChildren();
    }

    @Override
    public List<PackageDTO> getPackageByCity(int zipCode) throws Exception {
        String combined = EA.getApiMetaPackage() + zipCode;
        AllPackageDTO allPackageDTO = gson.fromJson(getPackageByCityNextLevel(new SingleFutureCallable().run(combined)), AllPackageDTO.class);
        return allPackageDTO.getPakkeshopData();
    }

    @Override
    public String getPackageByCityNextLevel(String test) {
        try {
            JsonElement je = new JsonParser().parse(test);
            JsonObject asJsonObject = je.getAsJsonObject();
            JsonElement get = asJsonObject.get("ArrayOfPakkeshopData");
            return get.toString();
        } catch (JsonSyntaxException ex) {
            throw ex;
        }
    }

    @Override
    public List<CityDTO> checkForSpaceInCityName(List<CityDTO> cities) {
        for (CityDTO citydto : cities) {
            if (citydto.getTitle().contains(" ")) {
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
