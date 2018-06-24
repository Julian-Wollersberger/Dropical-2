package at.dropical.shared;
// Created by julian on 24.06.18.

import at.dropical.shared.communication.ToClientMagic;
import at.dropical.shared.communication.local.LocalServer;

/**
 * Only sends data around with the LocalClient/ServerMagic.
 * Used in the tests for them.
 */
public class LocalMagicTestServer implements LocalServer {
    private ToClientMagic client;

    /** The Server is initialised by {@link ToClientMagic}. */
    @Override
    public void initialise(ToClientMagic client) {
        this.client = client;
    }

    /** Send all received inputs back to the client. */
    @Override
    public void update() {
        StringBuilder builder = new StringBuilder();
        builder.append(client.getCustomData()).append(" ");

        for(PlayerAction action : client.getPlayerActions()) {
            builder.append(action).append(" ");
        }
        client.sendCustomData(builder.toString());

        client.sendArena(new byte[10][20]);
        client.sendTetromino(new byte[4][4]);
        client.sendNextTetromino(new byte[4][4]);
        client.sendGameState(GameState.GAME_LOST);
    }

    @Override
    public void close() {
        System.out.println("Server is tired. Server goes to bed.");
    }

}
