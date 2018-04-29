package model;

import java.io.Serializable;

/**
 *  Created by J Michael
 */
public class Message implements Serializable {

    private String messageCode;

    private String message;
    private Object object;

    /**
     * Método constructor 1
     * @param messageCode
     */
    public Message(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * Método constructor 2
     * @param messageCode
     * @param message
     */
    public Message(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    /**
     * Método constructor 3
     * @param messageCode
     * @param object
     */
    public Message(String messageCode, Object object) {
        this.messageCode = messageCode;
        this.object = object;
    }

    /***** Getters and Setters ******/

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return messageCode != null ? messageCode.equals(message.messageCode) : message.messageCode == null;
    }

    @Override
    public int hashCode() {
        return messageCode != null ? messageCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageCode='" + messageCode + '\'' +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
