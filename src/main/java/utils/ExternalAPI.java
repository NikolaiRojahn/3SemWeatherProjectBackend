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
    //private final String groupXFetchEventByCityName = "https://www.metaweather.com/api/location/search/?query=";

    public String getApiMetaWeatherCity() {
        return apiMetaWeatherCity;
    }

    public String getApiMetaWeatherDataByCityId() {
        return apiMetaWeatherDataByCityId;
    }

//    public String getGroupXFetchEventByCityName() {
//        return groupXFetchEventByCityName;
//    }
        
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
