package model;

import model.CalendarioBase;
import model.DbManager;
import model.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by J Michael
 */
public class HandleOperation {

    private static DbManager dbManager;
    private ObjectOutputStream dos;
    private Message message;

    /**
     * Método Constructor
     */
    public HandleOperation(ObjectOutputStream dos) {
        dbManager = new DbManager("asico", "root", "michael123");
        this.dos = dos;
    }



    /**
     * @param data
     */
    public void insertBaseCalendar(ArrayList<CalendarioBase> data) throws IOException {

        dbManager.firstInsertCalendarioBase(data);
        message = new Message("firstInsertCalendarioBase_response", new Boolean(true));
        dos.writeObject(message);

    }

    /**
     * return time
     */
    public void getTime() {
        try {

            String msg = "La hora es " + LocalDateTime.now();
            message = new Message("time", msg);
            dos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCalendariBase_test(Message message){

        System.out.println("test_object : " + message.toString());

    }
}
