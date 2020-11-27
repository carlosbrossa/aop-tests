package com.example;

import com.example.model.Client;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyObject;

import java.util.HashMap;
import java.util.Map;

public class Container {

    private final Map<Class<?>, Watcher> watchers = new HashMap<>();

    public void register(Class<Client> type, Watcher watcher) {
        watchers.put(type, watcher);
    }

    public <T> T get(Class<T> type) throws Exception {

        final javassist.util.proxy.ProxyFactory factory = new javassist.util.proxy.ProxyFactory();
        factory.setSuperclass(Client.class);

        T instance = (T) factory.createClass().getDeclaredConstructor().newInstance();
        MethodHandler methodHandler = (instance1, method, proceed, args) -> {
            Watcher watcher = watchers.get(type);
            watcher.notifyInvocation(method);
            System.out.println(method);
            return proceed.invoke(instance1, args);
        };

        ((ProxyObject) instance).setHandler(methodHandler);
        return instance;

    }
}
