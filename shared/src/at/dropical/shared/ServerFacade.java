package at.dropical.shared;
// Created by julian on 24.06.18.

/**
 * <h1>Client to Server Communication</h1>
 * Easy to use API / Facade / Adapter for the Client
 * to communicate to the server.
 *
 * <h1>Coordinate System</h1>
 * All arrays (Arena, Tetrominos) must follow the coordinate axes
 * convention from mathematics:
 *
 * <ul>
 *     <li> x = 0 is the left border and x increases by going right. </li>
 *     <li> y = 0 is the bottom and y increases upwards. </li>
 *     <li> Array are indexed <code>arr[x][y]</code></li>
 * </ul>
 */
public interface ServerFacade {

    /*discuss In my opinion, this should be the job of
     * a concrete implementation.  */
    //void connect() throws IllegalStateException;

    byte[][] getArena();
    byte[][] getTetromino();
    int getTetrX();
    int getTetrY();
    byte[][] getNextTetromino();
    /*GamePhase*/ void getGamePhase();

    void close();
}
