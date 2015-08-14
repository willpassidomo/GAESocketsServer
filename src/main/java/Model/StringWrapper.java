/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author otf
 */
public class StringWrapper {
    private String string;
    
    public StringWrapper(String string) {
        this.string = string;
    }
    
    public String getString() {
        return this.string;
    }
    
    public void setString(String string) {
        this.string = string;
    }
}
