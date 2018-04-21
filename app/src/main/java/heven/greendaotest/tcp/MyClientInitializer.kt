package heven.greendaotest.tcp

import android.content.Context
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.timeout.IdleStateHandler
import io.netty.util.CharsetUtil
import java.util.concurrent.TimeUnit

class MyClientInitializer(private val context: Context?) : ChannelInitializer<SocketChannel>() {
    override fun initChannel(ch: SocketChannel?) {
        System.out.println("---initChannel---")
        val pipeline = ch!!.pipeline()!!.apply {
            addLast("encode", StringEncoder(CharsetUtil.UTF_8))
            addLast("decoder", StringDecoder(CharsetUtil.UTF_8))
            addLast(LoggingHandler(LogLevel.TRACE))
            addLast("ping", IdleStateHandler(120, 5, 120, TimeUnit.SECONDS))
            addLast("handler", MyClientHandler())
        }
    }

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        System.out.println("---channelRead--- msg=$msg")
        super.channelRead(ctx, msg)
    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        System.out.println("---channelReadComplete---")
        super.channelReadComplete(ctx)
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        System.out.println("---channelActive---")
        super.channelActive(ctx)
    }
}