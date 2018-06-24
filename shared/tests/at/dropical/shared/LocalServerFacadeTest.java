package at.dropical.shared;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// Created by julian on 24.06.18.

/**
 * TODO Description
 */
class LocalServerFacadeTest {

    private ServerFacade server;

    @BeforeEach
    void setUp() {
        server = new LocalServerFacade();
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