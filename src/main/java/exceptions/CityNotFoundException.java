package exceptions;

public class CityNotFoundException extends Exception{

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException() {
        super("Could not find weather for the requested city.");
    }  
}