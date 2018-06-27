package at.dropical.server.singleplayer

// Created by julian on 24.06.18.

import at.dropical.shared.PlayerAction
import at.dropical.shared.communication.ToClientMagic
import java.util.*

/**
 * One player. Does the Tetris logic.
 *
 * @param rng Random Number Generator. Set manually
 * to get consistent test results.
 */
class SinglePlayer(
        private val client: ToClientMagic,
        //private val clock = Clock() //Synchronise multiple games.
        private val rng: Random = Random()
): Runnable, AutoCloseable {

    /** Update & process the game logic.
     * Just run this frequently enough, it has its own
     * time management. TODO */
    override fun run() {
    }

    override fun close() {
        println("Morgen Ausflug zum Bayer-Park!")
    }
}
