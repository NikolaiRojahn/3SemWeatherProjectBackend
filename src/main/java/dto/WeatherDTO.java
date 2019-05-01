package dto;

/**
 *
 * @author nr
 */
public class WeatherDTO {

    private String weatherType, unit;
    private double temperature;
    private int wind;

    public WeatherDTO() {
    }

    public WeatherDTO(String weatherType, String unit, double temperature, int wind) {
        this.weatherType = weatherType;
        this.unit = unit;
        this.temperature = temperature;
        this.wind = wind;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    
}
