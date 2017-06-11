package com.myRpc.hello;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {

    static Executor executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket();

        serverSocket.bind(new InetSocketAddress(hostName, port));

        while (true) {
            executor.execute(new ExporterTask(serverSocket.accept()));
        }
    }

}


