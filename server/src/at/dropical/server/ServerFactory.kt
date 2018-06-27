package at.dropical.server

import at.dropical.server.singleplayer.LocalSingleplayerServer
import at.dropical.shared.communication.local.LocalServer


// Created by julian on 25.06.18.
/**
 * Just an idea.
 * We could make this the only public class in the
 * entire server module.
 */
object ServerFactory {

    /** @return a LocalServer instance that can be given
     * to a new LocalToServerMagic. */
    fun createSingleplayer(): LocalServer {
        return LocalSingleplayerServer()
    }

    fun createLocalTwoPlayer() {

    }
}