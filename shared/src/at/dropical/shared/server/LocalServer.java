package at.dropical.shared.server;
// Created by julian on 24.06.18.

/**
 * TODO Description
 * discuss The alternative would be lambda expressions.
 *
 * When using a remote server with sockets,
 * the server probably must be initialised
 * in other ways.
 */
public interface LocalServer {

    void initialise(ToClientMagic client);
    void update();
    void close();
}
