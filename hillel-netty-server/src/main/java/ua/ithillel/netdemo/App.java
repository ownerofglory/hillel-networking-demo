package ua.ithillel.netdemo;

import ua.ithillel.netdemo.server.NettyServer;

public class App {
    public static void main(String[] args) {
        final NettyServer nettyServer = new NettyServer(8020);
        nettyServer.run();
    }
}
