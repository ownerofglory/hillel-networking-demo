package ua.ithillel.netdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class App {
    public static void main(String[] args) {
        try {
            final DatagramSocket datagramSocket = new DatagramSocket(8001);
           while (true) {

               final byte[] buffer = new byte[256];
               final DatagramPacket clientDatagram = new DatagramPacket(buffer, buffer.length);

               datagramSocket.receive(clientDatagram);

               final InetAddress clientAddr = clientDatagram.getAddress();
               final int clientPort = clientDatagram.getPort();

               final byte[] data = clientDatagram.getData();
               final String message = new String(data);
               System.out.printf("%s:%s - %s", clientAddr, clientPort, message);

               if (message.contains("STOP"))  {
                   break;
               }
           }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
