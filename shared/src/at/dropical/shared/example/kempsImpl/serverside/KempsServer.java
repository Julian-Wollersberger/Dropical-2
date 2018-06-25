package at.dropical.shared.example.kempsImpl.serverside;

import java.io.IOException;
import java.util.ArrayList;

public class KempsServer {

    public static final int gamePort=46000;
    public static final int adminPort=46664;

    public static KempsServer instance=new KempsServer();

    public boolean isTounamentServer=true;

    public ArrayList<KempsGame> games=new ArrayList<>();
    public ArrayList<KempsUser> user=new ArrayList<>();


    public KempsServer(){
        try {
            KempsConnectionHandler.start(gamePort);
            KempsWebInterface.start(adminPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
