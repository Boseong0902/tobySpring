package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @UnitTest // Test애너테이션에 대해 정의된 메타 애너테이션
    void simpleHelloService(){
        SimpleHelloService helloservice = new SimpleHelloService();

        String ret = helloservice.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void HelloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name->name);
        String ret = decorator.sayHello("Test");
        assertThat(ret).isEqualTo("*Test*");
    }
}