package dto;

public class WeatherDTO {

    private long id;
    private double min_temp, max_temp, the_temp, wind_speed;
    private String weather_state_name, weather_state_abbr, wind_direction_compass, applicable_date;

    public WeatherDTO() {
    }

    public WeatherDTO(long id, double min_temp, double max_temp, double the_temp, double wind_speed, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String applicable_date) {
        this.id = id;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.applicable_date = applicable_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    @Override
    public String toString() {
        return "WeatherDTO{" + "id=" + id + ", min_temp=" + min_temp + ", max_temp=" + max_temp + ", the_temp=" + the_temp + ", wind_speed=" + wind_speed + ", weather_state_name=" + weather_state_name + ", weather_state_abbr=" + weather_state_abbr + ", wind_direction_compass=" + wind_direction_compass + ", applicable_date=" + applicable_date + '}';
    }

}
