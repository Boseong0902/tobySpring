package tobyspring.helloboot;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
// 이제 이 클래스에 frontController가 매핑하도록 만들거임
//@RestController
public class HelloController {
//    @GetMapping("/hello")
    public String hello(String name){
        return "AnotherHello" + name;
    }
}