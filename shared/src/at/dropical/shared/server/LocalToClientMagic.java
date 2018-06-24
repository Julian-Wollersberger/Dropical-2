package at.dropical.shared.server;
// Created by julian on 24.06.18.

import at.dropical.shared.PlayerAction;
import at.dropical.shared.client.LocalToServerMagic;

import java.util.List;

/**
 * TODO Description
 */
public class LocalToClientMagic implements ToClientMagic {

    private LocalServer localServer;
    private LocalToServerMagic clientEnd;

    public LocalToClientMagic(LocalServer localServer, LocalToServerMagic clientEnd) {
        this.localServer = localServer;
        this.clientEnd = clientEnd;
    }

    @Override
    public List<PlayerAction> getPlayerActions() {
        return null;
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
    public void sendGameState() {

    }
}
