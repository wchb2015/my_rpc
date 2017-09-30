package com.wchb.myrpc.hello;


import com.wchb.myrpc.annotation.RpcService;

@RpcService(IEchoService.class)
public class EchoServiceImpl implements IEchoService {

    public String echo(String ping) {
        return "I am ok , " + ping;
    }

}
