package ua.ithillel.netdemo.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.LocalDateTime;

public class SimpleServer extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = "Hello: " + LocalDateTime.now();

        final ChannelFuture write = ctx.write(message);
        ctx.flush();
    }
}
