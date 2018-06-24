package at.dropical.shared.client;
// Created by julian on 24.06.18.

/**
 * TODO Description
 * Makes a local Server
 */
public class LocalToServerMagic implements ToServerMagic {



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
    public void getGamePhase() {

    }

    @Override
    public void updateServer() {

    }

    @Override
    public void close() {

    }
}
