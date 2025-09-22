package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService; // 컨트롤러에서 의존성 주입받을 변수 선언

    public HelloController(HelloService helloService){
        // HelloService의 구현체(SimpleHelloService)를 Bean에 등록해놓고,
        // HelloController의 생성자 파라미터로 HelloService인터페이스를 받는다고 해놓으면
        // 스프링 컨테이너가 알아서 HelloController에 HelloService의 구현체인 SimpleHelloService의존성을 주입해줌

        this.helloService = helloService; // 생성자 파라미터로 HelloService인터페이스의 구현체를 전달받음
    }

    public String hello(String name){
//        SimpleHelloService simpleHelloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name)); // 어떤 구현체를 전달받느냐에 따라서 오버라이딩된 sayHello가 달라질 수 있음

    }
}