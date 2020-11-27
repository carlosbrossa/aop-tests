package com.example;

import java.lang.reflect.Method;

public class ClientWatcher implements Watcher{

    private int invocation;

    @Override
    public void notifyInvocation(Method method) {
        System.out.println(method + " metodo foi chamado");
        invocation++;
    }

    public int getInvocation() {
        return invocation;
    }
}
