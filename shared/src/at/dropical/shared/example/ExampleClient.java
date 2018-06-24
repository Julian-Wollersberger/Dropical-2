package at.dropical.shared.example;
// Created by julian on 23.06.18.

import at.dropical.shared.client.LocalToServerMagic;
import at.dropical.shared.client.ToServerMagic;

import java.util.Arrays;

/**
 * Here be dragons.
 * Or the example code on how to use our
 * client/server communication interface.
 */
public class ExampleClient /*extends LibGDX Game*/ {

    /** Represents the LibGDX DesktopLauncher
     * and internal GameLoop. */
    public static void main(String[] args) {
        ExampleClient client = new ExampleClient();
        client.create();

        client.render();
        client.render();
        client.render();

        client.dispose();
    }

    /** Our local server */
    private ToServerMagic server;

    public void create() {
        server = new LocalToServerMagic();
    }

    public void render() {
        byte[][] arena = server.getArena();
        byte[][] tetromino = server.getTetromino();
        int posX = server.getTetrX();
        int posY = server.getTetrY();
        byte[][] nextTetromino = server.getNextTetromino();

        System.out.println("Arena:\n"+ Arrays.deepToString(arena));
        System.out.println("Tetromino:\n"+ Arrays.deepToString(tetromino));
        System.out.println("Next Tetromino:\n"+ Arrays.deepToString(nextTetromino));
        System.out.println("X position of tetromino: "+ posX);
        System.out.println("Y position of tetromino: "+ posY);

        server.updateServer();
    }

    public void dispose() {

    }
}

/* I have bug in my code and they won't go,
 * glitches in my code and they won't go. */