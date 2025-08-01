/*package com.ctw.workstation.simple;

import com.ctw.workstation.team.entity.TeamDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class HelloExtAcademyTest2 {

    @Spy
    ExternalMessageServiceImpl externalMessageServiceImpl;
    @Mock
    ExternalMessageService externalMessageService;
    @InjectMocks
    HelloExtAcademy helloExtAcademy;

    @Test
    @DisplayName("When providing a null name a message from outersace should be returned")
    void when_providing_a_null_name_a_message_from_outersace() {
        //given
        String name = null;
        Mockito.doThrow(IllegalArgumentException.class)
                .when(externalMessageService)
                .sayHelloFromOuterSpace();
*//*
        Mockito.when(externalMessageService.sayHelloFromOuterSpace())
                .thenReturn("Hello from outer space");
*//*

        //when
        Mockito.doNothing()
                .when(externalMessageServiceImpl)
                .fazAlgo();
        String actualName = helloExtAcademy.sayHello(name);
        //then
        Assertions.assertThat(actualName)
                .as("valid message is returned even when provided a null name a message from outersace")
                .isEqualTo("Houston we have a problem");
    }
}*/
