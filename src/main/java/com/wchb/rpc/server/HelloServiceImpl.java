package com.wchb.rpc.server;

import com.wchb.rpc.annotation.RpcService;

@RpcService(IHelloService.class)
public class HelloServiceImpl implements IHelloService {

    @Override
    public String hello(String name) {
        return "from server " + name;
    }

}
