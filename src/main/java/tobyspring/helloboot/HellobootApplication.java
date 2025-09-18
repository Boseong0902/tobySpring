package tobyspring.helloboot;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

//@SpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
//		SpringApplication.run(HellobootApplication.class, args);
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(); //TomcatServletWebServer를 생성하는 여러 도구들을 모아놓은 class
		// 여기서 Tomcat뿐만 아니라 Jetty나 다른 서블릿들도 생성해서 사용할 수 있음 -> 구현되어있
		WebServer webServer = factory.getWebServer(); //서블릿 컨테이너 생성 메서드
		webServer.start(); // 톰캣 서블릿 컨테이너 동작
	}

}
