package at.dropical.client.testui

import at.dropical.shared.PlayerAction
import at.dropical.shared.communication.ToServerMagic
import at.dropical.shared.communication.local.LocalToServerMagic
import at.dropical.shared.example.ExampleServer
import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.paint.Paint
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

import java.io.IOException

fun main(args: Array<String>) {
    Application.launch(TestUI::class.java, *args)
}

class TestUI : Application() {

    private var scene: Scene? = null
    /** A local server.  */
    private val server: ToServerMagic = LocalToServerMagic(ExampleServer())

    @Throws(IOException::class)
    override fun start(primaryStage: Stage) {
        scene = Scene(Label("New Game Starting"), (32 * 10 * 2).toDouble(), (32 * 20).toDouble())
        primaryStage.scene = scene

        scene!!.setOnKeyPressed { event ->
            /* I love Kotlin. when returns a PlayerAction. */
            server.sendAction( when (event.code) {
                KeyCode.W -> PlayerAction.ROTATE_CLOCKWISE
                KeyCode.A -> PlayerAction.LEFT
                KeyCode.S -> PlayerAction.DOWN
                KeyCode.D -> PlayerAction.RIGHT
                KeyCode.SPACE -> PlayerAction.DROP
                KeyCode.P -> PlayerAction.PAUSE
                else -> PlayerAction.NOKEY
            })
        }
        primaryStage.show()

        // Endless looping thread that terminates
        // when application is closed.
        val loopTread = Thread {
            // Render with 30fps.
            while (!Thread.currentThread().isInterrupted /*nor an InterruptedException is thrown*/) {
                Platform.runLater(this::render)
                Thread.sleep(1000 / 30)
            }
        }
        loopTread.isDaemon = true
        loopTread.start()
    }


    fun render() {
        server.updateServer()

        // Designed for two players.
        val root = HBox()
        val left = GridPane()
        val right = GridPane()
        root.children.addAll(left, right)

        //Bug: Kotlin does not want to compare Byte and Int.
        val zero: Byte = 0

        // Render Arena
        for (y in 0..19) {
            for (x in 0..9) {
                left.add(Rectangle(32.0, 32.0,
                        if (server.arena[x][y] != zero)
                            Paint.valueOf("green")
                        else Paint.valueOf("white")
                ), x, y)
            }
        }

        //Render Tetromino
        for (y in 0..3) {
            for (x in 0..3) {
                if (server.tetrY + y >= 0 && server.tetromino[x][y] != zero)
                    if (server.tetromino[x][y] != zero)
                        left.add(Rectangle(32.0, 32.0, Paint.valueOf("darkgreen")),
                                server.tetrX + x, server.tetrY + y)
            }
        }
        root.setMinSize((32 * 10 * 20).toDouble(), (32 * 20).toDouble())
        scene!!.root = root
    }
}