package ua.ithillel.netdemo.server;

import java.sql.Connection;

public interface ChatHandler extends AutoCloseable {
    void onConnect(ChatConnection connection);
    void onMessage(ChatConnection connection, String message);
    void onDisconnect(ChatConnection connection);
    void onError(ChatConnection connection, Exception e);
}
