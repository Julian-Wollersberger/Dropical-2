package at.dropical.shared.server;
// Created by julian on 24.06.18.

import at.dropical.shared.PlayerAction;

import java.util.Collection;
import java.util.List;

/**
 * TODO Description
 *
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
public interface ToClientMagic {

    /** A player can press more than one button at a time,
     * and send multiple inputs. */
    List<PlayerAction> getPlayerActions();

    void sendArena(byte[][] arena);
    void sendTetromino(byte[][] tetromino);
    void sendTetrX(int x);
    void sendTetrY(int y);
    void sendNextTetromino(byte[][] nextTetromino);
    void sendGameState(/*GamePhase*/);
}
