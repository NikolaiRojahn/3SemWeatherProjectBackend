/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author nr
 */
public class ExternalServerError extends Exception{
    
    public ExternalServerError(String message) {
        super(message);
    }

    public ExternalServerError() {
        super("The connection to external dependencies are not valid at the moment. Please try again when the sun is rising!.");
    }  
    
}
