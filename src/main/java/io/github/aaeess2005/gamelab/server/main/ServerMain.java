package io.github.aaeess2005.gamelab.server.main;

import io.github.aaeess2005.gamelab.SharedConstants;
import io.github.aaeess2005.gamelab.server.net.Client;
import io.github.aaeess2005.gamelab.util.DeltaUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain implements Runnable {
    public boolean isRunning;
    private ServerSocket serverSocket;
    private List<Client> clients = new ArrayList<>();

    public ServerMain(InetAddress hostname, int port) {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(hostname, port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            DeltaUtil.resetDelta();
            //将TPS（Tick per Second）维持为指定数值
            maintainTPS(SharedConstants.TPS);
        }
        //停止运行
        stop();
    }

    public void initServer() {
    }

    public void acceptClient() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Client client = new Client(serverSocket.accept());
                    clients.add(client);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setName("ClientListener");
        thread.start();
    }

    public void tick() {
    }

    public void broadcastToClient() {
    }

    public void maintainTPS(float TPS) {
        float d = 1f / TPS;
        if (DeltaUtil.getDelta() < d) {
            try {
                Thread.sleep((long) (d * 1_000f - DeltaUtil.getDelta() * 1_000f));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
    }
}