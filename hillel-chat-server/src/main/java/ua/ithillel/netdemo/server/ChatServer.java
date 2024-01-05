package ua.ithillel.netdemo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer implements ChatHandler, AutoCloseable {
    private final ServerSocket serverSocket;
    private final List<ChatConnection> connections = new ArrayList<>();

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (!serverSocket.isClosed()) {
            final Socket socket = serverSocket.accept();

            ChatConnection connection = new DefaultChatConnection(socket, this);
        }
    }

    @Override
    public void onConnect(ChatConnection connection) {
        connections.forEach(c -> c.sendMessage(connection.getName() + " entered the chat"));
        connections.add(connection);
    }

    @Override
    public void onMessage(ChatConnection connection, String message) {
        for (ChatConnection conn :
                connections) {
            conn.sendMessage("[" + connection.getName() + "]: " + message);
        }
    }

    @Override
    public void onDisconnect(ChatConnection connection) {
        connections.remove(connection);
        connections.forEach(c -> c.sendMessage(connection.getName() + " left the chat"));
    }

    @Override
    public void onError(ChatConnection connection, Exception e) {
        connection.sendMessage("Error occurred: " + e.getMessage());
    }

    @Override
    public void close() throws Exception {
        if (!serverSocket.isClosed()) {
            serverSocket.close();
        }
    }
}
