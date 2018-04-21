package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import heven.greendaotest.R
import heven.greendaotest.tcp.MyClientInitializer
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.net.InetSocketAddress
import java.util.*
import java.util.concurrent.TimeUnit

class NettyActivity : BaseActivity() {
    private var group: NioEventLoopGroup? = null

    override fun getLayoutResID(): Int = R.layout.activity_netty

    override fun initActivity() {
        connect()
    }

    private fun connect() {
        Thread(Runnable {
            group = NioEventLoopGroup()
            val bootstrap = Bootstrap().apply {
                channel(NioSocketChannel::class.java)
                handler(MyClientInitializer(this@NettyActivity))
                option(ChannelOption.SO_KEEPALIVE, true)
                option(ChannelOption.TCP_NODELAY, true)
                group(group)
                remoteAddress("192.168.19.1", 5678)
            }
            val future = bootstrap.connect(InetSocketAddress("192.168.19.1", 5678))

            if (future.isSuccess) {
                System.out.println("connect server  success|")
            }

            Observable.interval(1, 5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe {
                        val json = "{\"loginChannel\":0,\"newUser\":false,\"token\":\"C338B5CFEED2778BA8E8E79A652C7CC7\",\"uid\":100916}"
                        val cmd = 2000

                        val length: Short = (json.length + 6).toShort()

                        val channel = future.sync().channel()
                        channel.write(length)
                        channel.write(cmd)
                        channel.write(json)
                        channel.flush()

                        System.out.println("interval server  success|" + channel.isRegistered)
                    }


        }).start()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NettyActivity::class.java)
            context.startActivity(intent)
        }
    }
}