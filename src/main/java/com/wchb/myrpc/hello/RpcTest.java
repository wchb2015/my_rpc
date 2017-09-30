package com.wchb.myrpc.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class RpcTest {

    private static final Logger logger = LoggerFactory.getLogger(RpcTest.class);

    private static String host = "127.0.0.1";

    private static int port = 8088;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                RpcExporter.exporter(host, port);
            } catch (Exception e) {
                logger.error(" error ", e);
            }
        }).start();

        RpcImporter<IEchoService> importer = new RpcImporter<>();
        IEchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress(host, port));

        logger.info(" result :{}", echo.echo("haha"));
    }
}
