package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloservice = new SimpleHelloService();

        String ret = helloservice.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }
}