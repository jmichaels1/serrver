package server;

import entity.Token;
import entity.Universidad;
import model.Dato;
import model.HandleOperation;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                closeConnection();
        }

    }

    /**
     * process Request
     *
     */
    private void processRequest() throws IOException, ClassNotFoundException, SQLException {

        Dato message = (Dato) dis.readObject();
        handleOperation = new HandleOperation(dos);

        switch (message.getMessageCode()) {

            case "time":
                handleOperation.getTime();
                break;
            case "date":
                dos.writeUTF("El día es " + LocalDate.now());
                break;

            case "test" :
                handleOperation.getCalendariBase_test(message);
                break;

            case "comprobarCuenta":
                handleOperation.comprobarCuenta((Map<String, String>) message.getObject());
                break;

            case "comprobarToken":
                handleOperation.comprobarToken((Token) message.getObject());
                break;

            case "getToken":
                handleOperation.getToken((String) message.getObject());
                break;

            case "getMasters":
                handleOperation.getMasters((Universidad) message.getObject());
                break;

            case "getPlanificacionCalendarios":
//                handleOperation.getPlanificacionCalendarios((Map<String, Object>) message.getObject());
                break;

            case "getCursos":
                handleOperation.getCursos((Universidad) message.getObject());
                break;

            case "logoutToken":
                handleOperation.logoutToken((Token) message.getObject());
                break;
            case "firstListBaseCalendar":
                handleOperation.insertDataInitCalendar((HashMap<String, ArrayList>) message.getObject());
                break;
        }
    }


    /**
     * clos connection
     */
    public void closeConnection() {
        try {
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
