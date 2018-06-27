package at.dropical.server.singleplayer.states

import at.dropical.server.singleplayer.SinglePlayer
import at.dropical.shared.PlayerAction


// Created by julian on 27.06.18.
/**
 * The game is not running.
 * The users must not see the field because otherwise
 * they might pause to stop the time for thinking and
 * therefore cheat.
 */
class PausedState(player: SinglePlayer) : GameLogicState(player) {
    override val doLogicAndInputs: Boolean = false
    override val doSendData: Boolean = false

    override fun processSpecialAction(action: PlayerAction) { //TODO
    }
}