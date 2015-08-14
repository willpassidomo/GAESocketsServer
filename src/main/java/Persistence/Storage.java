/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Exceptions.IncorrectPasswordException;
import Model.User;

/**
 *
 * @author otf
 */
public class Storage {
    private static Storage storage;
    
    public static Storage getInstance() {
        if (storage != null) {
            storage = new Storage();
        }
        return storage;
    }
    
    public User logIn(String userName, String password) throws IncorrectPasswordException {
        return null;
    }
    
    //This will map the sessionId to the user name who owns it
    public void registerSessionId(String sessionId, User user) {
        //stub
    }
    
    //Looks up the user by the sessionId 
    public User getUserBySessionId(String sessionId) {
        return null;
    }
    
    public User getUserByUserName(String userName) {
        return null;
    }
    
    public boolean isUserLoggedIn(String userName) {
        return false;
    }
    
}
