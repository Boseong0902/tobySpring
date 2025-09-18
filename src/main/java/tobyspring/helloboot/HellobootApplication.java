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
import org.springframework.http.HttpStatus;

import java.io.IOException;

//@SpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
//		SpringApplication.run(HellobootApplication.class, args);
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		WebServer webServer = factory.getWebServer(new ServletContextInitializer() {
			HelloController helloController = new HelloController(); // helloController가져와서
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.addServlet("frontController", new HttpServlet() { // frontController를 만들어보자
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						if(req.getRequestURI().equals("/hello") && req.getMethod().equals("GET")) { // hello패스로 get요청 받으면
						String name = req.getParameter("name");

						String ret = helloController.hello(name); // 리턴값 만들어주고

						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader("Content-Type", "text/plain");
						resp.getWriter().println(ret); // 리턴값 출력
						}
						else if(req.getRequestURI().equals("/users")){
							//정의
						}
						else{
							resp.setStatus(HttpStatus.NOT_FOUND.value()); // 요청 못찾음 404
						}
					}
				}).addMapping("/*"); // 모든 요청이 다 frontController를 거치도록
			}
		});
		webServer.start();
	}

}
