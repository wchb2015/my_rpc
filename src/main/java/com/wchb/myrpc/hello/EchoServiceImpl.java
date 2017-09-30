package com.wchb.myrpc.hello;

public class EchoServiceImpl implements IEchoService {

    public String echo(String ping) {
        return "I am ok , " + ping;
    }

}
