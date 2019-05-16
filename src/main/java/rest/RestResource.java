package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CityDTO;
import dto.PackageDTO;
import dto.WeatherDTO;
//import entity.User;
import exceptions.CityNotFoundException;
import facade.DataFacade;
import facade.WeatherFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import utils.PuSelector;

@Path("weather")
public class RestResource {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static WeatherFacade wf = new WeatherFacade();
    private static DataFacade df = DataFacade.getInstance(PuSelector.getEntityManagerFactory("pu"));

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

//OUTSOURCING CODE - JAVA SPRING FRAMEWORK
//@RequestMapping(value = "/today/{city}", method = RequestMethod.GET)
//public ResponseEntity<WeatherDTO> forecastOneDayByCityName(@PathVariable(name = "city", required = true) String cityName){
//  return new ResponseEntity<>(datafacade.getForecastOneDayByCityName(cityName), HttpStatus.OK);
//}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/today/{city}")
    public Response getWeatherForTodayByCityname(@PathParam("city") String cityname) throws Exception {
        try {
            WeatherDTO weatherDTO = wf.getWeatherForToday(cityname);
            df.newSearchCity(cityname);
            return Response.ok().entity(gson.toJson(weatherDTO)).build();
        } catch (CityNotFoundException ex) {
            throw new WebApplicationException(ex.getMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

//OUTSOURCING CODE - JAVA SPRING FRAMEWORK
//@RequestMapping(value = "/5days/{city}", method = RequestMethod.GET)
//public ResponseEntity<List<WeatherDTO>> forecastFiveDaysByCityName(@PathVariable(name = "city", required = true) String cityName){
//  return new ResponseEntity<>(datafacade.forecastFiveDaysByCityName(cityName), HttpStatus.OK);
//}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/5days/{city}")
    public Response getWeatherFiveDaysByCityName(@PathParam("city") String cityname) throws Exception {
        try {
            List<WeatherDTO> weatherDTOlist = wf.getWeatherByCity(cityname);
            df.newSearchCity(cityname);
            return Response.ok().entity(gson.toJson(weatherDTOlist)).build();
        } catch (CityNotFoundException ex) {
            throw new WebApplicationException(ex.getMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/popularcities")
    public Response getMostSearchedCities() {
        return Response.ok().entity(gson.toJson(df.getMostSearchedCities())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/country/{woeid}")
    public Response getWeatherForTodayByCityname(@PathParam("woeid") int woeid) throws Exception {
        List<CityDTO> cityDTOlist = wf.getCityByCountry(woeid);
        return Response.ok().entity(gson.toJson(cityDTOlist)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gls/{zipCode}")
    public Response getPackageInfo(@PathParam("zipCode") int zipCode) throws Exception {
        List<PackageDTO> packageList = wf.getPackageByCity(zipCode);
        return Response.ok().entity(gson.toJson(packageList)).build();
    }
    
    //    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getInfoForAll() {
//        return "{\"msg\":\"Hello anonymous\"}";
//    }
//    //Just to verify if the database is setup
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("all")
//    public String allUsers() {
//        EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
//        try {
//            List<User> users = em.createQuery("select user from User user").getResultList();
//            return "[" + users.size() + "]";
//        } finally {
//            em.close();
//        }
//
//    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("user")
//    @RolesAllowed("user")
//    public String getFromUser() {
//        String thisuser = securityContext.getUserPrincipal().getName();
//        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("admin")
//    @RolesAllowed("admin")
//    public String getFromAdmin() {
//        String thisuser = securityContext.getUserPrincipal().getName();
//        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
//    }

}

//    // mangler error handling!!!!!!!!!!!!!!!!!!!!!!!!!!!!! try catch osv...
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/symbol/{abb}")
//    public Response getWeatherSymbol(@PathParam("abb") String abbreviation) throws MalformedURLException, IOException{
//        String link = wf.getWeatherSymbol(abbreviation);
//        URL url = new URL(link);
//        BufferedImage image = ImageIO.read(url);
//        System.out.println(image);
//        return Response.ok(gson.toJson(image)).build();
//    }
//    @RequestMapping(value = "/today/{city}", method = RequestMethod.GET)
//	public ResponseEntity<WeatherDTO> forecastOneDayByCityName(@PathVariable(name = "city", required = true) String cityName){
//		return new ResponseEntity<>(datafacade.getForecastOneDayByCityName(cityName), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/5days/{city}", method = RequestMethod.GET)
//	public ResponseEntity<List<WeatherDTO>> forecastFiveDaysByCityName(@PathVariable(name = "city", required = true) String cityName){
//		return new ResponseEntity<>(datafacade.forecastFiveDaysByCityName(cityName), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/today/europe-capitals", method = RequestMethod.GET)
//	public ResponseEntity<List<WeatherDTO>> forecastEuropeCapitalsToday(){
//		return new ResponseEntity<>(datafacade.forecastEuropeCapitalsToday(), HttpStatus.OK);
//	}
//package rest;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import dto.CityDTO;
//import dto.WeatherDTO;
//import entity.User;
//import facade.WeatherFacade;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import javax.annotation.security.RolesAllowed;
//import javax.persistence.EntityManager;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;
//import utils.PuSelector;
//
///**
// * @author lam@cphbusiness.dk
// */
//@Path("weather")
//public class RestResource {
//
//    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    private static WeatherFacade wf = new WeatherFacade();
//
//    @Context
//    private UriInfo context;
//
//    @Context
//    SecurityContext securityContext;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getInfoForAll() {
//        return "{\"msg\":\"Hello anonymous\"}";
//    }
//
//    //Just to verify if the database is setup
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("all")
//    public String allUsers() {
//        EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
//        try {
//            List<User> users = em.createQuery("select user from User user").getResultList();
//            return "[" + users.size() + "]";
//        } finally {
//            em.close();
//        }
//
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("user")
//    @RolesAllowed("user")
//    public String getFromUser() {
//        String thisuser = securityContext.getUserPrincipal().getName();
//        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("admin")
//    @RolesAllowed("admin")
//    public String getFromAdmin() {
//        String thisuser = securityContext.getUserPrincipal().getName();
//        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
//    }
//
////OUTSOURCING CODE - JAVA SPRING FRAMEWORK
////@RequestMapping(value = "/today/{city}", method = RequestMethod.GET)
////public ResponseEntity<WeatherDTO> forecastOneDayByCityName(@PathVariable(name = "city", required = true) String cityName){
////  return new ResponseEntity<>(datafacade.getForecastOneDayByCityName(cityName), HttpStatus.OK);
////}
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/today/{city}")
//    public Response getWeatherForTodayByCityname(@PathParam("city") String cityname) throws Exception {
//        CityDTO cityDTO = wf.getWoeidForCity(cityname);
//        WeatherDTO weatherDTO = wf.getWeatherForToday(cityname);
//        return Response.ok().entity(gson.toJson(weatherDTO)).build();
//    }
//
////OUTSOURCING CODE - JAVA SPRING FRAMEWORK
////@RequestMapping(value = "/5days/{city}", method = RequestMethod.GET)
////public ResponseEntity<List<WeatherDTO>> forecastFiveDaysByCityName(@PathVariable(name = "city", required = true) String cityName){
////  return new ResponseEntity<>(datafacade.forecastFiveDaysByCityName(cityName), HttpStatus.OK);
////}
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/5days/{city}")
//    public Response getWeatherFiveDaysByCityName(@PathParam("city") String cityname) throws Exception {
//        List<WeatherDTO> weatherDTOlist = wf.getWeatherByCity(cityname);
//        return Response.ok().entity(gson.toJson(weatherDTOlist)).build();
//
//    }
//
////	@RequestMapping(value = "/today/europe-capitals", method = RequestMethod.GET)
////	public ResponseEntity<List<WeatherDTO>> forecastEuropeCapitalsToday(){
////		return new ResponseEntity<>(datafacade.forecastEuropeCapitalsToday(), HttpStatus.OK);
////	}
////  @GET
////  @Produces(MediaType.APPLICATION_JSON)
////  @Path("starwars-characters")
////  public Response getStarActors() throws IOException, InterruptedException, ExecutionException{
////      RequestUrl req = new RequestUrl();
////      List<String> starWars = req.runParallelCharacters();
////      return Response.ok().entity(gson.toJson(starWars)).build();
////  }
////  
////  @GET
////  @Produces(MediaType.APPLICATION_JSON)
////  @Path("starwars-planets")
////  public Response getStarWarsPlanets() throws IOException, InterruptedException, ExecutionException{
////      RequestUrl req = new RequestUrl();
////      List<String> starWars = req.runParallelPlanets();
////      return Response.ok().entity(gson.toJson(starWars)).build();
////  }
////  
////   @GET
////  @Produces(MediaType.APPLICATION_JSON)
////  @Path("starwars-ships")
////  public Response getStarWarsShips() throws IOException, InterruptedException, ExecutionException{
////      RequestUrl req = new RequestUrl();
////      List<String> starWars = req.runParallelShips();
////      return Response.ok().entity(gson.toJson(starWars)).build();
////  }
//}
