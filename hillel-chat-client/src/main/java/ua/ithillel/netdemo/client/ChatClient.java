package ua.ithillel.netdemo.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements AutoCloseable {
    private final Socket socket;

    public ChatClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
    }

    public void connect() {
        try {
            final InputStream inputStream = socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();


            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                final String s = reader.readLine();
                System.out.println(s);

                final Scanner scanner = new Scanner(System.in);
                final String userMessage = scanner.nextLine();

                if (userMessage.equals("STOP")) {
                    break;
                }

                writer.println(userMessage);
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void close() throws Exception {
        socket.close();
    }
}
