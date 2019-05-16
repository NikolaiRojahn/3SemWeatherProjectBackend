package interfaces;

import dto.CityDTO;
import dto.PackageDTO;
import dto.WeatherDTO;
import java.util.List;

public interface WeatherInterface {

    public CityDTO getWoeidForCity(String cityname) throws Exception;

    public List<WeatherDTO> getWeatherByCity(String cityname) throws Exception;

    public WeatherDTO getWeatherForToday(String cityname) throws Exception;

    public List<CityDTO> getCityByCountry(int woeid) throws Exception;

    public List<PackageDTO> getPackageByCity(int zipCode) throws Exception;
    
    public String getPackageByCityNextLevel(String test);
    
    public List<CityDTO> checkForSpaceInCityName(List<CityDTO> cities);
}
