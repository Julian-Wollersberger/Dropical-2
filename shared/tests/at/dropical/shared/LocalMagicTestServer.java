package at.dropical.shared;
// Created by julian on 24.06.18.

import at.dropical.shared.communication.ToClientMagic;
import at.dropical.shared.communication.local.LocalServer;

/**
 * Only sends data around with the LocalClient/ServerMagic.
 * Used in the test for them.
 */
public class LocalMagicTestServer implements LocalServer {
    private ToClientMagic client;

    /** The Server is initialised by {@link ToClientMagic}. */
    @Override
    public void initialise(ToClientMagic client) {
        this.client = client;
    }

    /** Process the most complicated game logic ever. */
    @Override
    public void update() {

    }

    @Override
    public void close() {
        System.out.println("Server is tired. Server goes to bed.");
    }

}
