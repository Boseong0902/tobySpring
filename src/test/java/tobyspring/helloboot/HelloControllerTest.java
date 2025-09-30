package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HelloControllerTest {
    @Test
    void helloController(){
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failHelloController(){
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(()->{
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);
        // null값을 넣어도 테스트 통과

        Assertions.assertThatThrownBy(()->{
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
        // 빈 문자열을 넣어도 테스트 통과
    }
}