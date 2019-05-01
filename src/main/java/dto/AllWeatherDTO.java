package dto;

import java.util.List;

/**
 * The purpose of AllWeatherDTO: Make a collection of single weatherDTO (WeatherDTO class)
 * @author Morten
 * @version 1.0
 * @since 01-05-2019
 */

public class AllWeatherDTO {

    List<WeatherDTO> consolidated_weather;

    public List<WeatherDTO> getConsolidated_weather() {
        return consolidated_weather;
    }

}
