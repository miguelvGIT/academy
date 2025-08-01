package com.ctw.workstation.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HelloExtAcademyTest {

    HelloExtAcademy helloExtAcademy;
    ExternalMessageService externalMessageServiceSpy;

    @BeforeEach
    void setup() {

        externalMessageServiceSpy = Mockito.spy(new ExternalMessageServiceImpl());
        helloExtAcademy = new HelloExtAcademy(externalMessageServiceSpy);
    }

    @Test
    @DisplayName("When providing a null name a message from outersace should be returned")
    void when_providing_a_null_name_a_message_from_outersace() {
        //given
        String name = null;
        Mockito.doReturn("Hey Rennan")
                .when(externalMessageServiceSpy)
                .sayHelloFromOuterSpace(name);
        //when
        String actualName = helloExtAcademy.sayHello(name);
        //then
        Assertions.assertThat(actualName)
                .as("valid message is returned even when provided a null name a message from outersace")
                .isEqualTo("Hello from outer space");
    }

    @Test
    @DisplayName("When providing a valid name a hello message from outerspace should be returned")
    void when_providing_a_valid_name_a_hello_message_from_outerspace() {
        //given
        String name = "Rennan";
        String outroName = "Wanderley";
        Mockito.when(externalMessageServiceSpy.sayHelloFromOuterSpace(name))
                .thenReturn("Hello Rennan");
        String actualName = helloExtAcademy.sayHello(name);
        //then
        Assertions.assertThat(actualName)
                .isEqualTo("Hello Rennan");

    }
}