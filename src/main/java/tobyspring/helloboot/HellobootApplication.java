package tobyspring.helloboot;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

//@SpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext(); // 스프링 컨테이너 구현 인터페이스
		applicationContext.registerBean(HelloController.class);
		applicationContext.refresh();

//		SpringApplication.run(HellobootApplication.class, args);
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		WebServer webServer = factory.getWebServer(new ServletContextInitializer() {
//			HelloController helloController = new HelloController();
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.addServlet("frontController", new HttpServlet() { // frontController를 만들어보자
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						if(req.getRequestURI().equals("/hello") && req.getMethod().equals("GET")) { // hello패스로 get요청 받으면
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.hello(name);

						resp.setStatus(HttpStatus.OK.value());
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
						}
						else if(req.getRequestURI().equals("/users")){
							//정의
						}
						else{
							resp.setStatus(HttpStatus.NOT_FOUND.value()); // 요청 못찾음 404
						}
					}
				}).addMapping("/*");
			}
		});
		webServer.start();
	}

}
