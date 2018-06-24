package at.dropical.shared.communication.local;
// Created by julian on 24.06.18.

import at.dropical.shared.communication.ToClientMagic;

/**
 * The {@link ToClientMagic} must know what
 * functions to call on the server, therefore
 * a local server has to implement this interface.
 *
 * discuss The alternative would be lambda expressions / method references.
 *
 * When using a remote server with sockets,
 * the server probably must be initialised
 * in other ways.
 */
public interface LocalServer {

    /** May only be called once in singleplayer
     * but multiple times if the server can handle multiplayer.
     * DISCUSS confusing in singleplayer. Maybe rename to initialise() */
    void initialise(ToClientMagic client);
    //void addPlayer(ToClientMagic client) throws IllegalStateException;

    /* Called by external game loop. */
    void update();
    void close();
}
