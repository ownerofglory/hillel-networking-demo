package ua.ithillel.netdemo;

import ua.ithillel.netdemo.client.ChatClient;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
//        try (ChatClient client = new ChatClient("localhost", 8000)) { // loopback
        try (ChatClient client = new ChatClient("127.0.0.1", 8000)) {
            client.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
