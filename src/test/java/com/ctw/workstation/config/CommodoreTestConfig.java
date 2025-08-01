package com.ctw.workstation.config;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceConfigurableLifecycleManager;
import io.quarkus.test.junit.QuarkusTest;

import java.util.Map;

@QuarkusTest
public class CommodoreTestConfig implements QuarkusTestResourceConfigurableLifecycleManager {

    @Override
    public Map<String, String> start() {
        Log.info("Starting Commodore test");
        return Map.of();
    }

    @Override
    public void stop() {
        Log.info("Stopping Commodore test");
    }

    @Override
    public void init(Map<String, String> initArgs) {
        Log.info("Initializing Commodore test");
    }
}
