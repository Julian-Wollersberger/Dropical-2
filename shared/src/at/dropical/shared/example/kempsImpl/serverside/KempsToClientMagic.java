package at.dropical.shared.example.kempsImpl.serverside;

import at.dropical.shared.GameState;
import at.dropical.shared.PlayerAction;
import at.dropical.shared.communication.ToClientMagic;
import at.dropical.shared.example.kempsImpl.KempsIO;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;


public class KempsToClientMagic implements ToClientMagic, KempsIO {

    private ArrayList playerActions = new ArrayList();
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    Map<String, Consumer<String>> functions = new TreeMap();


    public KempsToClientMagic(InputStream bufferedInputStream, OutputStream bufferedOutputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream));


        functions.put("state", this::sendCustomData);
    }

    @Override
    public List<PlayerAction> getPlayerActions() {
        return playerActions;
    }

    @Override
    public void sendArena(byte[][] arena) {

    }

    @Override
    public void sendTetromino(byte[][] tetromino) {

    }

    @Override
    public void sendTetrX(int x) {

    }

    @Override
    public void sendTetrY(int y) {

    }

    @Override
    public void sendNextTetromino(byte[][] nextTetromino) {

    }

    @Override
    public void sendGameState(GameState gameState) {
        try {
            bufferedWriter.write("{state=" + gameState + " }");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendCustomData(String string) {
        System.out.println(string);
    }

    @Override
    public String getCustomData() {
        return null;
    }

    @Override
    public void read() throws IOException {
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            try {
                String keyword = json.substring(1, json.indexOf("="));
                String data = json.substring(json.indexOf("=") + 1, json.length() - 1);
                functions.get(keyword).accept(data);
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
