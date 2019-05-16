/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author nr
 */
public class ExternalAPI {
    
    // Query parameter is String argument. The API will return the given City you searched for. Use the WOEID id to get the weather.
    private final String apiMetaWeatherCity = "https://www.metaweather.com/api/location/search/?query=";
    // Path parameter is a int (WOEID id from above API call), use this to get the weather data for the next 5 days. 
    private final String apiMetaWeatherDataByCityId = "https://www.metaweather.com/api/location/";
    //External API from other group in class
    private final String apiMetaPackage = "https://dieky.dk/jwtbackend/api/info/zipcode/";

    public String getApiMetaWeatherCity() {
        return apiMetaWeatherCity;
    }

    public String getApiMetaWeatherDataByCityId() {
        return apiMetaWeatherDataByCityId;
    }

    public String getApiMetaPackage() {
        return apiMetaPackage;
    }
        
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package utils;
//
///**
// *
// * @author nr
// */
//public class ExternalAPI {
//    
//    // Query parameter is String argument. The API will return the given City you searched for. Use the WOEID id to get the weather.
//    private final String apiMetaWeatherCity = "https://www.metaweather.com/api/location/search/?query=";
//    // Path parameter is a int (WOEID id from above API call), use this to get the weather data for the next 5 days. 
//    private final String apiMetaWeatherDataByCityId = "https://www.metaweather.com/api/location/";
//
//    public String getApiMetaWeatherCity() {
//        return apiMetaWeatherCity;
//    }
//
//    public String getApiMetaWeatherDataByCityId() {
//        return apiMetaWeatherDataByCityId;
//    }
//        
//}
