package com.ctw.workstation.simple;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloAcademyTest {

  private static final Logger log = Logger.getLogger(HelloAcademyTest.class);
  HelloAcademy helloAcademy;

  @BeforeAll
  void init() {
    helloAcademy = new HelloAcademy();
    log.info("Before All tests");
  }

  @BeforeEach
  void setup() {
    log.info("Before Each test");
  }

  @AfterEach
  void close(){
    log.info("After Each test");
  }

  @AfterAll
  void closeAll() {
    log.info("After All tests");
  }

  public static Stream<Arguments> provide_null_name() {
    return Stream.of(
            Arguments.of("Rennan", "Hello Rennan"),
            Arguments.of("Miguel", "Hello Miguel"),
            Arguments.of(null, "Hello")
    );
  }
  /*@Order(2)
  @ParameterizedTest
  @MethodSource(value = "provide_null_name")
  @DisplayName("When providing a null name to say hello just Hello should be returned")
  void provide_null_name_updated(String name) {
    // when
    String actualName = helloAcademy.sayHello(name);
    //then
    assertThat(actualName)
            .isNotNull()
            .isNotEmpty()
            .startsWith("Hello ");
  }*/

  public static Stream<Arguments> provide_empty_name() {
    return Stream.of(
            Arguments.of("Rennan", "Hello Rennan"),
            Arguments.of("Miguel", "Hello Miguel"),
            Arguments.of(null, "Hello")
    );
  }

  @Order(1)
  @ParameterizedTest
  @MethodSource(value = "provide_empty_name")
  @DisplayName("When providing a empty name to say hello just Hello should be returned")
  void provide_empty_name_outdated(String name, String expected) {
    //given
    // when
    String actualName = helloAcademy.sayHello(name);
    //then

    assertAll(
            () -> assertNotNull(actualName),
            () -> assertEquals(expected, actualName, "Returned name should be just Hello when providing a empty name")
    );
  }


}