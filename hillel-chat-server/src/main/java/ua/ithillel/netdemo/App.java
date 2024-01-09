package ua.ithillel.netdemo;

import ua.ithillel.netdemo.server.ChatServer;
import ua.ithillel.netdemo.server.Server;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws RuntimeException {
        try(Server chatServer = new ChatServer(8000)) {

            chatServer.start();

        } catch (Exception e) {
            System.out.println("Unable to start the server: " + e.getMessage());
        }
    }
}
