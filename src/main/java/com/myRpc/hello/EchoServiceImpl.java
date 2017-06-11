package com.myRpc.hello;

public class EchoServiceImpl implements IEchoService {

    public String echo(String ping) {
        return "I am ok , " + ping;
    }
}
