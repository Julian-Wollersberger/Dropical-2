package at.dropical.server.singleplayer.states

import at.dropical.server.singleplayer.SinglePlayer
import at.dropical.shared.PlayerAction


// Created by julian on 27.06.18.
/**
 * Normal gameplay.
 *
 * (If you could say "normal" to the insanely fast gameplay)
 */
class RunningState(player: SinglePlayer) : GameLogicState(player) {
    override val doLogicAndInputs: Boolean = true
    override val doSendData: Boolean = true

    override fun processSpecialAction(action: PlayerAction) { //TODO
    }
}