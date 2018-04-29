package server;

import model.CalendarioBase;
import model.HandleOperation;
import model.Message;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michael
 */
public class ServerThread extends Thread {

    private Socket socket;
    private ObjectOutputStream dos;
    private ObjectInputStream dis;

    HandleOperation handleOperation;

    /**
     * método constructor
     */
    public ServerThread(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {

        try {

            dis = new ObjectInputStream(socket.getInputStream());
            dos = new ObjectOutputStream(socket.getOutputStream());

            processRequest();
            dos.writeUTF("adios");


        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection();

//            try {
//                dis.close();
//                dos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }

    /**
     * process Request
     *
     */
    private void processRequest() throws IOException, ClassNotFoundException {

        Message message = (Message) dis.readObject();
        handleOperation = new HandleOperation(dos);

        switch (message.getMessageCode()) {

            case "time":
                handleOperation.getTime();
                break;
            case "date":
                dos.writeUTF("El día es " + LocalDate.now());
                break;

            case "firstListBaseCalendar":
                handleOperation.insertBaseCalendar((ArrayList<CalendarioBase>) message.getObject());
                break;

            case "test" :
                System.out.println("entra aqui");
                handleOperation.getCalendariBase_test(message);
                break;
        }
    }


    /**
     * clos connection
     */
    public void closeConnection() {

        try {

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
}
