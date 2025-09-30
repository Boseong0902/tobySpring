package tobyspring.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService{
    private final HelloService helloService;
    public HelloDecorator(@Qualifier("simple") HelloService helloService) {
        this.helloService = helloService; //HelloService구현체들의 의존성 주입
    }

    @Override
    public String sayHello(String name){
        return "*"+helloService.sayHello(name)+"*";
    }
}