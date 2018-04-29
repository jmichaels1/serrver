package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by J Michael on 13/04/2018.
 */
public class MultiThreadedServer implements Runnable {

    protected  final int PORT = 9090;
    protected ServerSocket serverSocket = null;
    protected  boolean isStoped = false;


    @Override
    public void run() {

        Socket clientSocket = null;

        try {

            serverSocket = new ServerSocket(PORT);
            System.out.println("comunicationEndIsFalse : " + isStoped);

            while (!isStoped){

                clientSocket = serverSocket.accept();

                System.out.println("nueva conexión()");

                new Thread(
                        new ServerThread(clientSocket))
                .start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * cerrar el socket temporal
     * para atender al cliente
     */
    public synchronized void sessionClose() {
        isStoped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
