package com.wchb.rpc.server;

import com.wchb.rpc.annotation.RpcService;

@RpcService(IHelloService.class)
public class HelloService2 implements IHelloService {

    @Override
    public String hello(String name) {
        return "from server7 " + name;
    }

}
