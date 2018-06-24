package at.dropical.shared.client;
// Created by julian on 24.06.18.

import at.dropical.shared.GameState;
import at.dropical.shared.PlayerAction;
import at.dropical.shared.server.LocalServer;
import at.dropical.shared.server.LocalToClientMagic;

/**
 * TODO Description
 * Makes a local Server
 */
public class LocalToServerMagic implements ToServerMagic {

    private LocalToClientMagic serverEnd;

    public LocalToServerMagic(LocalServer localServer) {
        serverEnd = new LocalToClientMagic(localServer, this);
    }

    @Override
    public void sendAction(PlayerAction action) {

    }

    @Override
    public void updateServer() {

    }

    @Override
    public byte[][] getArena() {
        return new byte[0][0];
    }

    @Override
    public byte[][] getTetromino() {
        return new byte[0][0];
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
        return new byte[0][0];
    }

    @Override
    public GameState getGameState() {
        return GameState.GAME_RUNNING;
    }

    @Override
    public void close() {

    }
}
