package ua.ithillel.netdemo.server;

public interface ChatConnection {
    void sendMessage(String message);
    String getName();
}
