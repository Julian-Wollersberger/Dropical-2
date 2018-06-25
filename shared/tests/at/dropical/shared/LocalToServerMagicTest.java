package at.dropical.shared;

import at.dropical.shared.communication.ToServerMagic;
import at.dropical.shared.communication.local.LocalToServerMagic;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
// Created by julian on 24.06.18.

/**
 * Test if the data is sent with
 * {@link LocalToServerMagic} and {@link at.dropical.shared.communication.local.LocalToClientMagic}
 */
class LocalToServerMagicTest {

    private ToServerMagic server;

    @BeforeEach
    void setUp() {
        server = new LocalToServerMagic(new LocalMagicTestServer());
    }

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