package at.dropical.shared.communication.local;
// Created by julian on 24.06.18.

import at.dropical.shared.GameState;
import at.dropical.shared.PlayerAction;
import at.dropical.shared.communication.ToClientMagic;

import java.util.List;

/**
 * TODO Description
 */
public class LocalToClientMagic implements ToClientMagic {

    private LocalServer localServer;
    private LocalToServerMagic clientEnd;

    public LocalToClientMagic(LocalToServerMagic clientEnd, LocalServer localServer) {
        this.clientEnd = clientEnd;
        this.localServer = localServer;
        localServer.addPlayer(this);
    }

    /* Package private fields that are read
     * in LocalToServerMagic.
     * Discuss Make a clone of the arrays, so the
     * client can't write on the same array instance the server has. */
    byte[][] arena;
    byte[][] tetromino;
    int x;
    int y;
    byte[][] nextTetromino;
    GameState gameState;

    /** Forwards call to server. */
    void updateServer() {
        localServer.update();
    }
    void close() {
        localServer.close();
    }

    /* Public methods for the server. */

    @Override
    public List<PlayerAction> getPlayerActions() {
        return clientEnd.getPlayerActions();
    }

    @Override
    public void sendArena(byte[][] arena) {
        this.arena = arena;
    }

    @Override
    public void sendTetromino(byte[][] tetromino) {
        this.tetromino = tetromino;
    }

    @Override
    public void sendTetrX(int x) {
        this.x = x;
    }

    @Override
    public void sendTetrY(int y) {
        this.y = y;
    }

    @Override
    public void sendNextTetromino(byte[][] nextTetromino) {
        this.nextTetromino = nextTetromino;
    }

    @Override
    public void sendGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
