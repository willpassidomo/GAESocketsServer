/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheAPIPackage;

/**
 *
 * @author willpassidomo
 */
public class StringWrapper {
    private String string;
    
    public StringWrapper(String string) {
        this.string = string;
    }

    /**
     * @return the string
     */
    public String getString() {
        return string;
    }

    /**
     * @param string the string to set
     */
    public void setString(String string) {
        this.string = string;
    }
}
