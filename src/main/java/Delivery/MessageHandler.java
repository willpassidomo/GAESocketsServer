/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import Model.Message;
import Model.User;
import Persistence.Storage;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otf
 */
public class MessageHandler {
    private static MessageHandler messageHandler;
    
    public static MessageHandler getInstance() {
        if (messageHandler == null) {
            messageHandler = new MessageHandler();
        }
        return messageHandler;
    }
    
    public void sendMessage(Message message) {
        if (Storage.getInstance().isUserLoggedIn(message.getUserTo())) {
            User userTo = Storage.getInstance().getUserByUserName(message.getUserTo());
            socketSend(userTo.getAddress(), userTo.getPort(), message);
        }
    }
    
//    private void socketAccept() {
//        try {
//            ServerSocket socket = new ServerSocket(8080);
//        } catch (IOException ex) {
//            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    }
    
    private void socketSend(String address, int port, Message message) {
        Socket socket;
        try {
            socket = new Socket(address, port);
            Writer out = new OutputStreamWriter(socket.getOutputStream());
            socket.setSoTimeout(10000);
            out.write(message.getUserFrom()+
                    "\r\n" + message.getServerDateStamp() + 
                    "\n\r" + message.getMessage());

        } catch (IOException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
