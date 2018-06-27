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
class LocalToServerMagicTest extends ToServerMagicHelper {

    @Override
    @BeforeEach
    void setUp() {
        server = new LocalToServerMagic(newTestServer());
    }

}