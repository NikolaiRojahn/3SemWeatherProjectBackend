package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "searchcity")
public class SearchCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "city_name", length = 50)
    private String cityname;
    
    public SearchCity(){
        
    }

    public SearchCity(String cityname) {
        this.cityname = cityname;
    }

    public String getCityName() {
        return cityname;
    }

    public void setCityName(String cityname) {
        this.cityname = cityname;
    }
    
    
}


