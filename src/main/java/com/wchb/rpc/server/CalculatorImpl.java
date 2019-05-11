package com.wchb.rpc.server;

import com.wchb.rpc.annotation.RpcService;

/**
 * @date 5/11/19 3:07 PM
 */

@RpcService(ICalculator.class)
public class CalculatorImpl implements ICalculator {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
