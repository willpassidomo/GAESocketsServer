/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheAPIPackage;



import Delivery.MessageHandler;
import Delivery.TestMessage;
import Exceptions.IncorrectPasswordException;
import Model.Coordinates;
import Model.Message;
import Model.StringWrapper;
import Model.User;
import Persistence.Storage;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.ThreadManager;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

@Api(name = "socketMessagerAPI",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "ServerSockets",
                ownerName = "ServerSockets",
                packagePath = ""),
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
            Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
/**
 *
 * @author otf
 */
public class TheAPI {
    
        public StringWrapper pingServer() {
        return new StringWrapper("Server Alive");
    }
        
        
    public StringWrapper logIn(@Named("username")String userName, 
            @Named("password")String password, 
            @Named("address")String address, 
            @Named("port")Integer port) {
        User user;
        try {
            if (userName == null || "".equals(userName)) {
                return new StringWrapper("UserName not included");
            }
            user = Storage.getInstance().logIn(userName, password);
            if (address == null || "".equals(address)) {
                return new StringWrapper("Address not included");
            }
            user.setAddress(address);
            if (port == 0) {
                return new StringWrapper("Port not included");
            }
            user.setPort(port);
        } catch (IncorrectPasswordException ex) {
            Logger.getLogger(TheAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new StringWrapper("Incorrect Password");
        }
        String sessionId = UUID.randomUUID().toString();
        Storage.getInstance().registerSessionId(sessionId, user);
        return new StringWrapper(sessionId);
    }
    
    public StringWrapper sendMessage(@Named("sessionId")String sessionId, @Named("username")String userName, 
            @Named("message")String message, Coordinates coordinates) {
        User sender = Storage.getInstance().getUserBySessionId(sessionId);
        Message messageObj = new Message(sender.getUserName(), userName, message);
        Date date = new Date();
        messageObj.setServerDateStamp(date.getTime());
        
        MessageHandler.getInstance().sendMessage(messageObj);
        return new StringWrapper("Success");
        
    }
    
    public StringWrapper testSocket(HttpServletRequest req, @Named("portnumber")Integer portNumber){
        String ipAddress = req.getRemoteAddr();
        ThreadManager.createThreadForCurrentRequest(new TestMessage(ipAddress, portNumber)).start();
        return new StringWrapper("Message Recieved");
    }
    
}
