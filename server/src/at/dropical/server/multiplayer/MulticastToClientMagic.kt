package at.dropical.server.multiplayer

import at.dropical.shared.GameState
import at.dropical.shared.PlayerAction
import at.dropical.shared.communication.ToClientMagic
import java.util.*


// Created by julian on 26.06.18.
/**
 * This class wraps a connection to
 * a client and multiple viewers.
 *
 * Only a sketch!
 */
class MulticastToClientMagic: ToClientMagic {

    private val client: ToClientMagic? = null //SocketMagic
    private val viewers = LinkedList<ToClientMagic>()

    override fun getPlayerActions(): MutableList<PlayerAction> {
        return client!!.playerActions
    }

    override fun sendArena(arena: Array<out ByteArray>?) {
        client!!.sendArena(arena)
        viewers.forEach{it.sendArena(arena)}
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
        return client!!.customData
    }
}