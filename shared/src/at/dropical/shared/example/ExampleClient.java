package at.dropical.shared.example;
// Created by julian on 23.06.18.

import at.dropical.shared.client.LocalToServerMagic;
import at.dropical.shared.client.ToServerMagic;

/**
 * Here be dragons.
 * Or the example code on how to use our
 * client/server communication interface.
 */
public class ExampleClient /*extends LibGDX Game*/ {

    /** Represents the LibGDX DesktopLauncher
     * and internal GameLoop. */
    public static void main(String[] args) {
        ExampleClient client = new ExampleClient();
        client.create();

        client.render();
        client.render();
        client.render();

        client.dispose();
    }

    private ToServerMagic server = new LocalToServerMagic();

    public void create() {

    }

    public void render() {

        server.updateServer();
    }

    public void dispose() {

    }
}

/* I have bug in my code and they won't go,
 * glitches in my code and they won't go. */