package dto;

public class PackageDTO {
    
    private String CompanyName, Streetname, CityName;
    private int ZipCode;

    public PackageDTO(String CompanyName, String Streetname, String CityName, int ZipCode) {
        this.CompanyName = CompanyName;
        this.Streetname = Streetname;
        this.CityName = CityName;
        this.ZipCode = ZipCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getStreetname() {
        return Streetname;
    }

    public void setStreetname(String Streetname) {
        this.Streetname = Streetname;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }
    
}
