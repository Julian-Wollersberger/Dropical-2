package at.dropical.shared.example.kempsImpl.serverside;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class KempsConnectionHandler extends Thread{
    private static ServerSocket serverSocket;

    public static void start(int port) throws IOException {
        serverSocket=new ServerSocket(port);
        new KempsConnectionHandler().start();
    }

    @Override
    public void run() {
        for(;;) {
            try {
                Socket socket=serverSocket.accept();
                KempsServer.instance.user.add(new KempsUser(new KempsToClientMagic(new GZIPInputStream(socket.getInputStream()),new GZIPOutputStream(socket.getOutputStream()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
