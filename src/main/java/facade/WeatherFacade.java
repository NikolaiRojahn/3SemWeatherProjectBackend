/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.ExternalAPI;

/**
 *
 * @author nr
 */
public class WeatherFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    ExternalAPI EA = new ExternalAPI();
    
    private final String findCityId = EA.getApiMetaWeatherCity();
    private final String findWeatherForCity = EA.getApiMetaWeatherDataByCityId();

}
