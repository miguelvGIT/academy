package com.ctw.workstation.simple;

import com.ctw.workstation.external.ExternalRequest;

public class HelloExtAcademy {


    ExternalMessageService externalMessageService;

    public HelloExtAcademy(ExternalMessageService externalMessageService) {
        this.externalMessageService = externalMessageService;
    }

    /*public String sayHello(String name) {
        if( name != null ) {
            return externalMessageService.sayHelloFromOuterSpace(name);
        } else {
            String helloOuterSpace = null;
            try {
                helloOuterSpace = externalMessageService.sayHelloFromOuterSpace();
            } catch (Throwable e) {
                return "Houston we have a problem";
            }
            externalMessageService.fazAlgo();
            return helloOuterSpace + "Academy";
        }
    }*/

    public String sayHello(String name) {
        if (name != null) {
            return externalMessageService.sayHelloFromOuterSpace(name);
        }
        return externalMessageService.sayHelloFromOuterSpace();
    }


}
