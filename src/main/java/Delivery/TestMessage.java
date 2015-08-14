/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otf
 */
public class TestMessage implements Runnable {

    String address;
    int portNumber;

    public TestMessage(String address, int portNumber) {
        this.address = address;
        this.portNumber = portNumber;
    }
    
    @Override
    public void run() {
        try {
            //sleep(5000);
            Socket socket = new Socket(address, portNumber);
            OutputStreamWriter outputString = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(outputString);
            PrintWriter out = new PrintWriter(bufferedWriter);
            out.println("test message after 0 seconds");      
        } catch (IOException ex) {
            Logger.getLogger(TestMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (InterruptedException ex) {
//            Logger.getLogger(TestMessage.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
