package ua.ithillel.netdemo.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import ua.ithillel.netdemo.model.RequestModel;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

public class RequestDecoder extends ReplayingDecoder<RequestModel> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {

        // TODO: read data from buffer
        final RequestModel request = new RequestModel("");

        list.add(request);
    }
}
