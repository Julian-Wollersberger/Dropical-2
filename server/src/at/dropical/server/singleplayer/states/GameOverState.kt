package at.dropical.server.singleplayer.states

import at.dropical.server.singleplayer.SinglePlayer
import at.dropical.shared.PlayerAction


// Created by julian on 27.06.18.
/**
 * Somebody lost the game.
 * @param isLost In singleplayer always true.
 * But in multiplayer someone else might have lost and therefore
 * this player won.
 *
 * Don't do anything anymore, but let the user see the field.
 */
class GameOverState(player: SinglePlayer, val isLost: Boolean) : GameLogicState(player) {
    override val doLogicAndInputs: Boolean = false
    override val doSendData: Boolean = true

    override fun processSpecialAction(action: PlayerAction) { //TODO
    }
}