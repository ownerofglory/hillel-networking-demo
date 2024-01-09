package ua.ithillel.netdemo.server;

public interface Server extends AutoCloseable {
    void start() throws Exception;
}
