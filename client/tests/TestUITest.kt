import at.dropical.client.testui.TestUI
import com.sun.javafx.robot.FXRobot
import com.sun.javafx.robot.impl.BaseFXRobot
import javafx.application.Application
import javafx.application.Platform
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

// Created by julian on 26.06.18.

/**
 * GUI testing is a bit more complicated.
 * https://vocabhunter.github.io/2016/07/27/TestFX.html
 */
internal class TestUITest/*: BaseFXRobot()*/ {

    /** Basically useless. */
    //@Test
    fun start() {
        Application.launch(TestUI::class.java, "")
        Platform.runLater {
            Platform.exit()
        }
    }
}