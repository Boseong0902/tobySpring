package tobyspring.helloboot;

import org.springframework.stereotype.Component;

@Component("complex")
public class ComplexHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Complex Hello " + name;
    }
}