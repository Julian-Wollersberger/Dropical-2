package at.dropical.shared.example.kempsImpl.serverside;

import java.io.IOException;
import java.net.ServerSocket;

public class KempsWebInterface {
    private static ServerSocket serverSocket;

    public static void start(int port) throws IOException {
        serverSocket=new ServerSocket(port);
    }



    public KempsWebInterface() {
    }

}
