package com.ctw.workstation.simple;

import com.ctw.workstation.config.CommodoreTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(CommodoreTestConfig.class)
class HelloExtAcademy2Test {

    @Inject
    HelloExtAcademy2 helloExtAcademy2;

    @Test
    @DisplayName("Say hello with valid name")
    void say_hello_with_valid_name() {
        //given
        String name = "Rennan";
        //when
        String actualHello = helloExtAcademy2.sayHello(name);
        Assertions.assertThat(actualHello).isEqualTo(name);
    }
}