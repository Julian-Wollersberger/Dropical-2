package at.dropical.server.singleplayer

import at.dropical.shared.GameState
import at.dropical.shared.PlayerAction
import at.dropical.shared.communication.ToClientMagic


// Created by julian on 27.06.18.
/**
 * An even simpler implementation than [LocalToClientMagic]
 * It does basically nothing.
 * 
 * This is to make the server tests independent of
 * LocalToClientMagic
 */
class DoNothingToClientMagic: ToClientMagic{
    
    override fun getPlayerActions(): MutableList<PlayerAction> {
        return ArrayList<PlayerAction>()
    }

    override fun sendArena(arena: Array<out ByteArray>?) {
    }

    override fun sendTetromino(tetromino: Array<out ByteArray>?) {
    }

    override fun sendTetrX(x: Int) {
    }

    override fun sendTetrY(y: Int) {
    }

    override fun sendNextTetromino(nextTetromino: Array<out ByteArray>?) {
    }

    override fun sendGameState(gameState: GameState?) {
    }

    override fun sendCustomData(string: String?) {
    }

    override fun getCustomData(): String {
        return ""
    }

}