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
public class Message {
    private String userFrom;
    private String userTo;
    private String message;
    private long dateSent;
    private long dateRecieved;
    private long serverDateStamp;
    
    public Message(String userFrom, String userTo, String message) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.message = message;
    }

    /**
     * @return the userFrom
     */
    public String getUserFrom() {
        return userFrom;
    }

    /**
     * @return the userTo
     */
    public String getUserTo() {
        return userTo;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the dateSent
     */
    public long getDateSent() {
        return dateSent;
    }

    /**
     * @param dateSent the dateSent to set
     */
    public void setDateSent(long dateSent) {
        this.dateSent = dateSent;
    }

    /**
     * @return the dateRecieved
     */
    public long getDateRecieved() {
        return dateRecieved;
    }

    /**
     * @param dateRecieved the dateRecieved to set
     */
    public void setDateRecieved(long dateRecieved) {
        this.dateRecieved = dateRecieved;
    }

    /**
     * @return the serverDateStamp
     */
    public long getServerDateStamp() {
        return serverDateStamp;
    }

    /**
     * @param serverDateStamp the serverDateStamp to set
     */
    public void setServerDateStamp(long serverDateStamp) {
        this.serverDateStamp = serverDateStamp;
    }
}
