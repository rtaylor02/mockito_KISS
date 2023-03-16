package withoutmockito;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testGreet() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello there!", helloWorld.greet("there"));
    }
}
