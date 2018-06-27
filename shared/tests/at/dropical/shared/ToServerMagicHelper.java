package at.dropical.shared;
// Created by julian on 27.06.18.

import at.dropical.shared.communication.ToServerMagic;
import at.dropical.shared.communication.local.LocalServer;
import at.dropical.shared.communication.local.LocalToServerMagic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test an implementation of ToServerMagic.
 */
public abstract class ToServerMagicHelper {

    protected ToServerMagic server;

    protected LocalServer newTestServer() {
        return new LocalMagicTestServer();
    }

    /* */
    @BeforeEach
    abstract void setUp();

    @Test
    void sendAction() {
        server.sendAction(PlayerAction.NOKEY);
        server.sendAction(PlayerAction.LEFT);
        server.updateServer();
        assertEquals("NOKEY LEFT ", server.getCustomData());

        // Test if queue is cleared
        server.sendAction(PlayerAction.RIGHT);
        server.updateServer();
        assertEquals("RIGHT ", server.getCustomData());
    }

    /** Nothing my be null even before the firs update.*/
    @Test
    void nothingNullTest() {
        assertNotNull(server.getArena());
        assertNotNull(server.getTetromino());
        assertNotNull(server.getNextTetromino());
        assertNotNull(server.getGameState());
        assertNotNull(server.getCustomData());
    }

    /** Is data plausible? */
    @Test
    void getDataTest() {
        server.sendCustomData("Wunderschöner String");
        server.updateServer();
        assertEquals("Wunderschöner String", server.getCustomData());

        //Richtige Array-Größe testen wäre toll.
    }

    @AfterEach
    void tearDown() {
        server.close();
    }
}
