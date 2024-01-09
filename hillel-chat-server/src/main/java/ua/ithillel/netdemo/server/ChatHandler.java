package ua.ithillel.netdemo.server;

import java.io.IOException;
import java.sql.Connection;

public interface ChatHandler {
    void onConnect(ChatConnection connection);
    void onMessage(ChatConnection connection, String message);
    void onDisconnect(ChatConnection connection);
    void onError(ChatConnection connection, Exception e);
}
