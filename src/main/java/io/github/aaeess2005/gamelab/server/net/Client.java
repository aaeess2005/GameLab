package io.github.aaeess2005.gamelab.server.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean isClosed;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    public void transport(DataPacket dataPacket) throws IOException {
        //TODO 发送
        outputStream.write(DataPacket.packetToBytes(dataPacket));
    }

    public DataPacket receive() throws IOException {
        //TODO 接收
        return null;
    }

    private void close() throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
