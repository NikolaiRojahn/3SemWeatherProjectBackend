package interfaces;

import dto.CityDTO;
import dto.PackageDTO;
import dto.WeatherDTO;
import java.util.List;

public interface WeatherInterface {

    public List<String> getUrlsToFetchFromByCity(String cityname);

    public void fetchCityObjectAndEventsByCityName(String cityname) throws Exception;

    public CityDTO getWoeidForCity() throws Exception;

    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception;

    public WeatherDTO getWeatherForToday(String cityname) throws Exception;

    public String getFindCityId();

    public String getFindWeatherForCity();

    public List<String> getFetchResultList();

    public List<CityDTO> getCityByCountry(int woeid) throws Exception;

    public List<PackageDTO> getPackageByCity(int zipCode);
    
    public String checkForSpaceInCityName(String cityname);
}
