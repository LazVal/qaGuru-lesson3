package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll
    static void startup() {
        System.out.println("tests startup");
    }

    @AfterAll
    static void testEnded() {
        System.out.println("tests ended");
    }
   @BeforeEach
    void startBrowser() {
       System.out.println("- Browser has started");
   }

    @AfterEach
    void stopBrowser() {
        System.out.println("- Browser has stop");
    }
    @Test
    void firstTest() {
        System.out.println("-- firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("-- secondTest");
    }
}
