package tobyspring.helloboot;

import org.springframework.stereotype.Component;

@myComponent
public class SimpleHelloService implements HelloService{
    @Override
    public String sayHello(String name){
        return "Hello " + name;
    }
}