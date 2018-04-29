import server.MultiThreadedServer;

/**
 * Created by J Michael on 13/04/2018.
 */
public class Main {



    public static void main(String[] args) throws InterruptedException {

        MultiThreadedServer server = new MultiThreadedServer();
        new Thread(server).start();

    }

}
