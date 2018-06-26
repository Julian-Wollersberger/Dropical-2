package at.dropical.server.singleplayer

// Created by julian on 24.06.18.

import at.dropical.shared.PlayerAction
import at.dropical.shared.communication.ToClientMagic

/**
 *
 */
class SinglePlayer(
        private val client: ToClientMagic
        //private val clock = Clock() //Synchronise multiple games.
): Runnable, AutoCloseable {

    /** Update & process the game logic.
     * Just run this frequently enough, it has its own
     * time management. */
    override fun run() {
    }

    override fun close() {
        println("Server is tired. Server goes to bed.")
    }
}
