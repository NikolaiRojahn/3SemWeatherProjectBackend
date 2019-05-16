package dto;

public class CityDTO {
    
    private String title, location_type, latt_long;
    private int woeid;

    public CityDTO(String title, String location_type, String latt_long, int woeid) {
        this.title = title;
        this.location_type = location_type;
        this.latt_long = latt_long;
        this.woeid = woeid;
    }

    public CityDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    public int getWoeid() {
        return woeid;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }
    
}
