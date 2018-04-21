package heven.greendaotest.tcp

import heven.greendaotest.utils.Logger
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler

class MyClientHandler : SimpleChannelInboundHandler<String>() {
    override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {
        Logger.d("MyHelloClientHandler", "channelRead0->msg=$msg")
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        System.out.println("Client active")
        super.channelActive(ctx)
    }

    override fun channelInactive(ctx: ChannelHandlerContext?) {
        System.out.println("Client close ")
        super.channelInactive(ctx)
    }
}