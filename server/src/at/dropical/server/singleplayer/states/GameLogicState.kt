package at.dropical.server.singleplayer.states

import at.dropical.server.singleplayer.SinglePlayer
import at.dropical.shared.PlayerAction

// Created by julian on 27.06.18.
/**
 * Every state can choose whether a certain part
 * of the logic should be done. Maybe ignore user
 * inputs and don't update when paused. But send
 * arena after game over.
 *
 * This time, make the states lightweight (not like Wolli's)
 * AND organised (not like Kempi's).
 */
abstract class GameLogicState(
        protected val player: SinglePlayer
) {
    /** Is the game running or paused?
     * React to PlayerActions like right, left, rotate, ... ?
     * But always react to start, pause and quit.*/
    abstract val doLogicAndInputs: Boolean
    /** Should the user see what he is doing
     * or send blank arena & tetromino? */
    abstract val doSendData: Boolean

    /** In every state you must react differently to
     * start, pause or quit. */
    abstract fun processSpecialAction(action: PlayerAction)
}