package com.example;

import java.lang.reflect.Method;

public interface Watcher {
    void notifyInvocation(Method method);
}
