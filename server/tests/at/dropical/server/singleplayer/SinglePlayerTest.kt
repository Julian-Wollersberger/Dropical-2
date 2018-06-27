package at.dropical.server.singleplayer

import org.junit.jupiter.api.Test

// Created by julian on 27.06.18.

/**
 * Without a magic connection not much can be tested.
 * Just if it doesn't crash.
 */
internal class SinglePlayerTest {

    @Test
    fun initRunClose() {
        val singlePlayer = SinglePlayer(DoNothingToClientMagic())
        singlePlayer.run()
        singlePlayer.run()
        singlePlayer.run()
        singlePlayer.close()
    }
}