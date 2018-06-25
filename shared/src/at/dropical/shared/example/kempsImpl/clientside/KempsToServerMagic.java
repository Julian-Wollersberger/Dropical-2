package at.dropical.shared.example.kempsImpl.clientside;

import at.dropical.shared.GameState;
import at.dropical.shared.PlayerAction;
import at.dropical.shared.communication.ToServerMagic;
import at.dropical.shared.example.kempsImpl.KempsIO;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class KempsToServerMagic implements ToServerMagic,KempsIO {

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    Map<String, Consumer<String>> functions = new TreeMap();


    public KempsToServerMagic(InputStream bufferedInputStream, OutputStream bufferedOutputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream));


        functions.put("state", this::sendCustomData);
    }

    @Override
    public void sendAction(PlayerAction action) {
        
    }

    @Override
    public void updateServer() {

    }

    @Override
    public byte[][] getArena() {
        return new byte[0][];
    }

    @Override
    public byte[][] getTetromino() {
        return new byte[0][];
    }

    @Override
    public int getTetrX() {
        return 0;
    }

    @Override
    public int getTetrY() {
        return 0;
    }

    @Override
    public byte[][] getNextTetromino() {
        return new byte[0][];
    }

    @Override
    public GameState getGameState() {
        return null;
    }

    @Override
    public void sendCustomData(String string) {

    }

    @Override
    public String getCustomData() {
        return null;
    }

    @Override
    public void close() {

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
