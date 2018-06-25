package at.dropical.shared.example;
// Created by julian on 24.06.18.

import at.dropical.shared.PlayerAction;
import at.dropical.shared.communication.local.LocalServer;
import at.dropical.shared.communication.ToClientMagic;

/**
 * This is a basic demonstration how the main class
 * of a server should look like.
 */
public class ExampleServer implements LocalServer {

    private ToClientMagic client;
    private int posX = 10;

    /** The Server is initialised by {@link ToClientMagic}. */
    @Override
    public void initialise(ToClientMagic client) {
        this.client = client;
    }

    /** Process the most complicated game logic ever. */
    @Override
    public void update() {
        for(PlayerAction action : client.getPlayerActions()) {
            if(action == PlayerAction.LEFT)
                posX--;
        }

        client.sendTetrX(posX);
        client.sendTetromino(new byte[][]{
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1},
                {1,0,1,0},
        });
    }

    @Override
    public void close() {
        System.out.println("Server is tired. Server goes to bed.");
    }
}
