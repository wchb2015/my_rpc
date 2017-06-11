package com.myRpc.hello;

import java.net.InetSocketAddress;

public class RpcTest {

    private static String host = "182.92.188.170";

    private static int port = 8088;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter(host, port);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<IEchoService> importer = new RpcImporter<>();
        IEchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress(host, port));
        System.out.println(echo.echo("haha"));
    }
}
