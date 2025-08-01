package com.ctw.workstation.simple;

import com.ctw.workstation.simple.MathOperations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathOperationsTest {

    MathOperations mathOperations;

    @BeforeAll
    void setUpBeforeClass(){
        mathOperations = new MathOperations();
    }

    public static Stream<Arguments> divide_by_zero() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(3, 4),
                Arguments.of(2,0)
        );
    }

    @Test
    public void divide_by_zero_updated() {
        //when

        //then

        Assertions.assertThrows(ArithmeticException.class, () -> mathOperations.divide(0, 0));
    }
}
