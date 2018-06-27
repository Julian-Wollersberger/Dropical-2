package at.dropical.server.singleplayer

// Created by julian on 24.06.18.

import at.dropical.server.singleplayer.gamefield.TetrisArena
import at.dropical.server.singleplayer.gamefield.Tetromino
import at.dropical.server.singleplayer.states.GameLogicState
import at.dropical.server.singleplayer.states.PausedState
import at.dropical.server.singleplayer.states.RunningState
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
        private val rand: Random = Random()
): Runnable, AutoCloseable {

    private var state: GameLogicState = RunningState(this)

    private var tetrisArena = TetrisArena()
    /** Current Tetromino  */
    private var tetromino = Tetromino.createRandom(rand)
    /** The tetromino that will be used when the current fell down.  */
    private var nextTetromino = Tetromino.createRandom(rand)
    /** Distance from left. */
    private var x: Int = TetrisArena.width / 2 - Tetromino.size / 2
    /** Distance from bottom. */
    private var y: Int = TetrisArena.height +1

    override fun run() { update() }
    /** Update & process the game logic.
     * Just run this frequently enough, it has its own
     * time management. TODO */
    fun update() {
        client.playerActions.forEach {
            state.processSpecialAction(it)
        }

        if (state.doLogicAndInputs) {
            client.playerActions.forEach {
                //Process
            }
            //TODO Do something
        }

        if (state.doSendData) {

        } else {
            //Send empty arena
        }
    }


    override fun close() {
        println("Morgen Ausflug zum Bayer-Park!")
    }
}
