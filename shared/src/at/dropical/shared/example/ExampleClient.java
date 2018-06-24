package at.dropical.shared.example;
// Created by julian on 23.06.18.

import at.dropical.shared.PlayerAction;
import at.dropical.shared.communication.local.LocalToServerMagic;
import at.dropical.shared.communication.ToServerMagic;

import java.util.Arrays;

/**
 * Here be dragons.
 * Or the example code on how to use our
 * client/server communication interface.
 */
public class ExampleClient /*extends Game*/ {

    /** Represents the LibGDX DesktopLauncher
     * and internal GameLoop. */
    public static void main(String[] args) {
        ExampleClient client = new ExampleClient();
        client.create();

        //while(true)
        client.render();
        client.render();
        client.render();

        client.dispose();
    }

    /** A local server. */
    private ToServerMagic server;

    /** Starts a new local server. */
    public void create() {
        server = new LocalToServerMagic(new ExampleServer());
    }

    /** Runs every frame. */
    public void render() {
        // Process user input.
        server.sendAction(PlayerAction.LEFT);
        // Run the game logic on the server.
        server.updateServer();

        // Render everything
        System.out.println("Arena:\n"+ Arrays.deepToString(server.getArena()));
        System.out.println("Tetromino:\n"+ Arrays.deepToString(server.getTetromino()));
        System.out.println("Next Tetromino:\n"+ Arrays.deepToString(server.getNextTetromino()));
        System.out.println("X position of tetromino: "+ server.getTetrX());
        System.out.println("Y position of tetromino: "+ server.getTetrY());
        System.out.println("Current game state: "+ server.getGameState());
    }

    /** When the application is closed */
    public void dispose() {
        server.close();
    }
}

/* I have bug in my code and they won't go,
 * glitches in my code and they won't go. */