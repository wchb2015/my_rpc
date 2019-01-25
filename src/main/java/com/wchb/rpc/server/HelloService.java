package com.wchb.rpc.server;


import com.wchb.rpc.annotation.RpcService;


@RpcService(value = IHelloService.class, version = "v1.1.2")
public class HelloService implements IHelloService {

    @Override
    public String hello(String name) {
        return "from server7 " + name;
    }

}
