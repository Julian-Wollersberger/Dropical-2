package at.dropical.shared;

import org.junit.jupiter.api.*;

// Created by julian on 24.06.18.

/**
 * TODO Description
 */
class LocalClientToServerMagicTest {

    private ClientToServerMagic server;

    @BeforeEach
    void setUp() {
        server = new LocalClientToServerMagic();
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