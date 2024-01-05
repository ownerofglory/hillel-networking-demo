package ua.ithillel.netdemo;

import ua.ithillel.netdemo.server.ChatHandler;
import ua.ithillel.netdemo.server.ChatServer;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try(ChatHandler chatServer = new ChatServer(8000)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
