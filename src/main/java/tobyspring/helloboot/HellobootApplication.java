package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;


@MySpringbootApplication
public class HellobootApplication {

	// 위 두 팩토리 메서드도 따로 빼주자 - springinitializr와 최대한 같은 환경으로 만들어보자
	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args); // 이게 바로 우리가 기존에 쓰던 @SpringBootApplication 애너테이션
	}
}