package dto;

public class PackageDTO {
    
    private String CompanyName;
    private int Number;

    public PackageDTO() {
    }

    public PackageDTO(String CompanyName, int Number) {
        this.CompanyName = CompanyName;
        this.Number = Number;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }
    
}
