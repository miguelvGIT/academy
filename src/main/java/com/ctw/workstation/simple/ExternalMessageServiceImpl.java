package com.ctw.workstation.simple;

import io.quarkus.logging.Log;

public class ExternalMessageServiceImpl implements ExternalMessageService {
    @Override
    public String sayHelloFromOuterSpace() {
        return "Hello from outer space";
    }

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer space" + name;
    }

    @Override
    public void fazAlgo(){
        Log.info("Faz algo");
        throw new IllegalStateException("Can't be executed");
    }
}
