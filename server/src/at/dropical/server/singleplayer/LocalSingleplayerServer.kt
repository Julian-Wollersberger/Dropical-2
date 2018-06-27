package at.dropical.server.singleplayer

import at.dropical.shared.communication.ToClientMagic
import at.dropical.shared.communication.local.LocalServer
import java.lang.NullPointerException

// Created by julian on 26.06.18.
/**
 * Wraps a SinglePlayer to be a local server.
 * Initialises the SinglePlayer and forwards updates.
 */
class LocalSingleplayerServer: LocalServer {
    private lateinit var singlePlayer: SinglePlayer

    /**@Throws NullPointerException when client is null. */
    override fun initialise(client: ToClientMagic?) {
        singlePlayer = SinglePlayer(client!!)
    }

    override fun update() {
        singlePlayer.run()
    }

    override fun close() {
        singlePlayer.close()
    }
}