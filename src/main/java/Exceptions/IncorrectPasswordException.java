/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author otf
 */
public class IncorrectPasswordException extends Exception {
    String attempt;
    
    public IncorrectPasswordException(String attempt) {
        this.attempt = attempt;
    }
    
    public String getAttempt() {
        return this.attempt;
    }
}
