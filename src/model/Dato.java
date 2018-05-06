package model;

import java.io.Serializable;

public class Dato implements Serializable {

    private String messageCode;

    private String message;
    private Object object;

    /**
     * Constructor de envío de mensajes
     * @param messageCode
     */
    public Dato(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * Constructor con parametrización de código de envío y objeto
     * @param messageCode
     * @param object
     */
    public Dato(String messageCode, Object object) {
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

        Dato dato = (Dato) o;

        return messageCode != null ? messageCode.equals(dato.messageCode) : dato.messageCode == null;
    }

    @Override
    public int hashCode() {
        return messageCode != null ? messageCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Dato{" +
                "messageCode='" + messageCode + '\'' +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
