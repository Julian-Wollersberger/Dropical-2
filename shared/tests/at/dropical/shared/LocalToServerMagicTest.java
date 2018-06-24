package at.dropical.shared;

import at.dropical.shared.client.ToServerMagic;
import at.dropical.shared.client.LocalToServerMagic;
import org.junit.jupiter.api.*;

// Created by julian on 24.06.18.

/**
 * TODO Description
 */
class LocalToServerMagicTest {

    private ToServerMagic server;

    @BeforeEach
    void setUp() {
        server = new LocalToServerMagic();
    }

    @Test
    void getArenaTest() {
        server.getArena();
    }

    @AfterEach
    void tearDown() {
        server.close();
    }
}