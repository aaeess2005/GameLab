package io.github.aaeess2005.gamelab.server.main;

import java.net.InetAddress;

public class ServerMain implements Runnable {
    public boolean isRunning;
    private InetAddress hostname;
    private int port;

    public ServerMain(InetAddress hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        //初始化服务端
        initServer();
        //开启新线程处理客户端连接
        acceptClient();
        while (isRunning) {
            //处理游戏逻辑
            tick();
            //广播世界数据
            broadcastToClient();
        }
        //停止运行
        stop();
    }

    public void initServer() {
    }

    public void acceptClient() {
    }

    public void tick() {
    }

    public void broadcastToClient() {
    }

    public void stop() {
    }
}
