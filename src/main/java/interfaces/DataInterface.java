package interfaces;

import dto.SearchCityDTO;
import entity.SearchCity;
import java.util.List;

public interface DataInterface {

    public SearchCity getCitynameFromDB(String cityname);

    public List<SearchCity> getAllCitynameFromDB();

    public List<SearchCityDTO> getMostSearchedCities();

    public SearchCity newSearchCity(String cityname);
}
