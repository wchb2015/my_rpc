package com.wchb.myrpc.hello;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RpcImporter<S> {

    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;

                ObjectOutputStream outputStream = null;
                ObjectInputStream inputStream = null;

                try {
                    socket = new Socket();
                    socket.connect(addr);
                    outputStream = new ObjectOutputStream(socket.getOutputStream());

                    outputStream.writeUTF(serviceClass.getName());
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(method.getParameterTypes());

                    outputStream.writeObject(args);
                    inputStream = new ObjectInputStream(socket.getInputStream());

                    return inputStream.readObject();
                } catch (Exception e) {

                } finally {
                    if (socket != null) {
                        socket.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                return null;
            }
        });
    }

}
